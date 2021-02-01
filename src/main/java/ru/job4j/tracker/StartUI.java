package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
               StartUI.findAllItem(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
               StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                System.out.println("Bye bye! See you soon!");
                run = false;
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItem(Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                Item value = items[i];
                System.out.println("value = " + value.getName());
            }
        } else {
            System.out.println("array is empty");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
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
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id"));
        if (tracker.delete(id)) {
            System.out.println("Operation `the delete` complied success");
        } else {
            System.out.println(
                    "Since id #"
                            + id + " not exists. Operation `the replace` cannot be complied"
            );
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id"));
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("The statement with this id don`t exists");
        } else {
            System.out.println(item.toString());
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
