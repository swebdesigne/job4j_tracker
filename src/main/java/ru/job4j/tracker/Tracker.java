package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    private Tracker() {

    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        items.add(item);
        item.setId(items.size() - 1);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item[] findByName(String key) {
        Item[] namesWithoutNull = new Item[items.size()];
        int index = 0;
        for (int i = 0; i < items.size(); i++) {
            Item value = items.get(i);
            if (key.equals(items.get(i).getName())) {
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
            items.set(id, item);
            item.setId(id);
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        if (id <= items.size()) {
            rsl = id;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(id);
        return true;
    }
}