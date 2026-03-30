import enums.Direction;
import enums.RequestType;
import models.*;
import services.ElevatorService;
import utils.IdGenerator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Floor f0 = new Floor(0, true, false);
        Floor f1 = new Floor(1, true, true);
        Floor f2 = new Floor(2, true, true);
        Floor f3 = new Floor(3, false, true);

        Elevator e1 = new Elevator(IdGenerator.generateId(), new ElevatorCar(0, 500));
        Elevator e2 = new Elevator(IdGenerator.generateId(), new ElevatorCar(2, 500));

        List<Floor> floors = Arrays.asList(f0, f1, f2, f3);
        List<Elevator> elevators = Arrays.asList(e1, e2);

        Building building = new Building(floors, elevators);
        ElevatorService elevatorService = new ElevatorService(building);

        Request request1 = new Request(0, 3, Direction.UP, RequestType.EXTERNAL);
        elevatorService.requestElevator(request1);

        Request request2 = new Request(2, 1, Direction.DOWN, RequestType.EXTERNAL);
        elevatorService.requestElevator(request2);

        System.out.println("\nTriggering emergency...");
        elevatorService.triggerEmergency();
    }
}