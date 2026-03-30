package models;

public class Floor {
    private int floorNumber;
    private Button upButton;
    private Button downButton;

    public Floor(int floorNumber, boolean hasUp, boolean hasDown) {
        this.floorNumber = floorNumber;
        this.upButton = hasUp ? new Button("UP") : null;
        this.downButton = hasDown ? new Button("DOWN") : null;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Button getUpButton() {
        return upButton;
    }

    public Button getDownButton() {
        return downButton;
    }
}