package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "Edit item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id"));
        String name = input.askStr("Enter name");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Operation `the replace` complied successfully");
            System.out.println("The new name is " + name);
        } else {
            System.out.println(
                    "Since id #"
                            + id + " not exists. Operation `the replace` cannot be complied"
            );
        }
        return true;
    }
}
