package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.getLocalDateAndTime();
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item);
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getId());
        }
    }
}
