package models;

import java.util.PriorityQueue;

public class ElevatorCar {
    private int currentFloor;
    private int maxWeight;
    private int currentWeight;
    private Door door;
    private PriorityQueue<Integer> requests;

    public ElevatorCar(int currentFloor, int maxWeight) {
        this.currentFloor = currentFloor;
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.door = new Door();
        this.requests = new PriorityQueue<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Door getDoor() {
        return door;
    }

    public PriorityQueue<Integer> getRequests() {
        return requests;
    }
}