package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    private final Output output;

    public FindItemByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find Item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("array is empty");
        } else {
            for (int i = 0; i < items.length; i++) {
                Item value = items[i];
                System.out.println(value.toString());
            }
        }
        return true;
    }
}
