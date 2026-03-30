package services;

import models.Elevator;
import models.Request;

public class ElevatorController {
    public void processRequest(Elevator elevator, Request request) {
        if (elevator == null) {
            System.out.println("No elevator available.");
            return;
        }

        elevator.moveToFloor(request.getSourceFloor());
        elevator.moveToFloor(request.getDestinationFloor());
    }
}