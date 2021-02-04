package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output output;

    public DeleteItem(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Delete Item ===");
        int id = Integer.parseInt(input.askStr("Enter id"));
        if (tracker.delete(id)) {
            output.println("Operation `the delete` complied success");
        } else {
            output.println(
                    "Since id #"
                            + id + " not exists. Operation `the replace` cannot be complied"
            );
        }
        return true;
    }
}
