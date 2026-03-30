package models;

import java.util.ArrayList;
import java.util.List;

public class Panel {
    private List<Button> buttons = new ArrayList<>();

    public void addButton(Button button) {
        buttons.add(button);
    }

    public List<Button> getButtons() {
        return buttons;
    }
}