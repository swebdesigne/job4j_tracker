package ru.job4j.tracker;

import java.util.Arrays;

public final class Tracker {
    private static Tracker instance = null;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private Tracker() {

    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] namesWithoutNull = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            Item value = items[i];
            if (key.equals(items[i].getName())) {
                namesWithoutNull[index] = value;
                index++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, index);
        return namesWithoutNull;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = item;
            item.setId(id);
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        int start = index + 1;
        int distPos = index;
        int length = size - index;
        System.arraycopy(items, start, items, distPos, length);
        items[size - 1] = null;
        size--;
        return true;
    }
}