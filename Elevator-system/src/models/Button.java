package models;

public class Button {
    private String label;
    private boolean pressed;

    public Button(String label) {
        this.label = label;
        this.pressed = false;
    }

    public void press() {
        this.pressed = true;
    }

    public void reset() {
        this.pressed = false;
    }

    public String getLabel() {
        return label;
    }

    public boolean isPressed() {
        return pressed;
    }
}