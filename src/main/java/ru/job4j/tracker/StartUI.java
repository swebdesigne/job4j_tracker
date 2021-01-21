package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.getLocalDateAndTime();
        Tracker tracker = new Tracker();
        tracker.add(item);
        item.setId(2);
        Item num = tracker.findById(2);
        System.out.println(num.getId());
        item.setName("igor");
        System.out.println(item);
    }
}
