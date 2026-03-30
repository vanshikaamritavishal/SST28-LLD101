package models;

import enums.Direction;
import enums.ElevatorState;

public class Elevator {
    private String id;
    private ElevatorCar car;
    private Direction direction;
    private ElevatorState state;

    public Elevator(String id, ElevatorCar car) {
        this.id = id;
        this.car = car;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
    }

    public String getId() {
        return id;
    }

    public ElevatorCar getCar() {
        return car;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public boolean isUnderMaintenance() {
        return state == ElevatorState.UNDER_MAINTENANCE;
    }

    public void moveToFloor(int destinationFloor) {
        if (isUnderMaintenance()) {
            System.out.println("Elevator " + id + " is under maintenance.");
            return;
        }

        state = ElevatorState.MOVING;
        direction = destinationFloor > car.getCurrentFloor() ? Direction.UP : Direction.DOWN;

        System.out.println("Elevator " + id + " moving from floor " + car.getCurrentFloor() + " to " + destinationFloor);

        car.setCurrentFloor(destinationFloor);
        state = ElevatorState.STOPPED;
        direction = Direction.IDLE;

        car.getDoor().openDoor();
        car.getDoor().closeDoor();

        state = ElevatorState.IDLE;
    }

    public void triggerAlarm() {
        System.out.println("Emergency alarm triggered in elevator " + id);
        state = ElevatorState.STOPPED;
    }

    public void setMaintenanceMode() {
        state = ElevatorState.UNDER_MAINTENANCE;
    }
}