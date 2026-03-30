package services;

import models.Building;
import models.Elevator;
import models.Request;

public class ElevatorService {
    private Building building;
    private Dispatcher dispatcher;
    private ElevatorController controller;

    public ElevatorService(Building building) {
        this.building = building;
        this.dispatcher = new Dispatcher();
        this.controller = new ElevatorController();
    }

    public void requestElevator(Request request) {
        Elevator elevator = dispatcher.assignElevator(building.getElevators(), request);
        controller.processRequest(elevator, request);
    }

    public void triggerEmergency() {
        for (Elevator elevator : building.getElevators()) {
            elevator.triggerAlarm();
        }
    }
}