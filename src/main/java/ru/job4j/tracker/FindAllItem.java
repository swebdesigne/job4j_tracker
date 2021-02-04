package ru.job4j.tracker;

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
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                Item value = items[i];
                output.println("value = " + value.getName());
            }
        } else {
            output.println("array is empty");
        }
        return true;
    }
}
