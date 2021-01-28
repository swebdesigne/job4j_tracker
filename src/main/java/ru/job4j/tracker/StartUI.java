package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    Item value = items[i];
                    if (value != null) {
                        System.out.println("value = " + value.getName());
                    } else {
                        System.out.println("value is null");
                    }
                }
            } else if (select == 2) {
                int id = Integer.parseInt(scanner.nextLine());
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    tracker.replace(id, item);
                    System.out.println("Operation `the replace` complied successfully");
                    System.out.println("The new name is " + name);
                } else {
                    System.out.println(
                            "Since id #"
                                    + id + " not exists. Operation `the replace` cannot be complied"
                    );
                }
            } else if (select == 3) {
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    tracker.delete(id);
                    System.out.println("Operation `the delete` complied success");
                } else {
                    System.out.println(
                            "Since id #"
                                    + id + " not exists. Operation `the replace` cannot be complied"
                    );
                }
            } else if (select == 4) {
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("The statement with this id don`t exists");
                } else {
                    System.out.println(item.getName());
                }
            } else if (select == 5) {
                String name = String.valueOf(scanner.nextLine());
                Item[] items = tracker.findByName(name);
                if (items.length < 0) {
                    System.out.println("Statement with this name don`t exists");
                } else {
                    for (int i = 0; i < items.length; i++) {
                        Item value = items[i];
                        System.out.println(value.getName());
                    }
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
        int select = Integer.valueOf(scanner.nextLine());
    }
}
