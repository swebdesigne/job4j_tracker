package ru.job4j.tracker;

public class FindAllItem implements UserAction {
    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                Item value = items[i];
                System.out.println("value = " + value.getName());
            }
        } else {
            System.out.println("array is empty");
        }
        return true;
    }
}
