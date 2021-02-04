package ru.job4j.tracker;

public class FindItemById implements UserAction {
    private final Output output;

    public FindItemById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find item by Id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find Item by id ===");
        int id = Integer.parseInt(input.askStr("Enter id"));
        Item item = tracker.findById(id);
        if (item == null) {
            output.println("The statement with this id don`t exists");
        } else {
            output.println(item.toString());
        }
        return true;
    }
}
