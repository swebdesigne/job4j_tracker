package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

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
        for (; index < size;) {
            Item value = items[index];
            if (key.equals(items[index].getName())) {
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