package models;

public class Door {
    private boolean open;

    public Door() {
        this.open = false;
    }

    public void openDoor() {
        this.open = true;
        System.out.println("Door opened");
    }

    public void closeDoor() {
        this.open = false;
        System.out.println("Door closed");
    }

    public boolean isOpen() {
        return open;
    }
}