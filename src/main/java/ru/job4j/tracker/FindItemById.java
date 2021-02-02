package ru.job4j.tracker;

public class FindItemById implements UserAction {
    @Override
    public String name() {
        return "Find item by Id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id"));
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("The statement with this id don`t exists");
        } else {
            System.out.println(item.toString());
        }
        return true;
    }
}
