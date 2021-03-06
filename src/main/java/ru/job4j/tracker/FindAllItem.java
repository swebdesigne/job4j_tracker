package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindAllItem implements UserAction {
    private final Output output;

    public FindAllItem(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find all Item ===");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                Item value = items.get(i);
                output.println("value = " + value.getName());
            }
        } else {
            output.println("array is empty");
        }
        return true;
    }
}
