package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id"));
        if (tracker.delete(id)) {
            System.out.println("Operation `the delete` complied success");
        } else {
            System.out.println(
                    "Since id #"
                            + id + " not exists. Operation `the replace` cannot be complied"
            );
        }
        return true;
    }
}
