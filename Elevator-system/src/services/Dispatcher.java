package services;

import models.Elevator;
import models.Request;

import java.util.List;

public class Dispatcher {
    public Elevator assignElevator(List<Elevator> elevators, Request request) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.isUnderMaintenance()) {
                continue;
            }

            int distance = Math.abs(elevator.getCar().getCurrentFloor() - request.getSourceFloor());
            if (distance < minDistance) {
                minDistance = distance;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }
}