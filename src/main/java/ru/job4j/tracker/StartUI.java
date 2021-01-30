package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (int i = 0; i < items.length; i++) {
                        Item value = items[i];
                        System.out.println("value = " + value.getName());
                    }
                } else {
                    System.out.println("array is empty");
                }
            } else if (select == 2) {
                int id = Integer.parseInt(input.askStr("Inter id"));
                String name = input.askStr("Inter name");
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
            } else if (select == 3) {
                int id = Integer.parseInt(input.askStr("Inter id"));
                if (tracker.delete(id)) {
                    System.out.println("Operation `the delete` complied success");
                } else {
                    System.out.println(
                            "Since id #"
                                    + id + " not exists. Operation `the replace` cannot be complied"
                    );
                }
            } else if (select == 4) {
                int id = Integer.parseInt(input.askStr("Inter id"));
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("The statement with this id don`t exists");
                } else {
                    System.out.println(item.toString());
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                System.out.println("Bye bye! See you soon!");
                break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
