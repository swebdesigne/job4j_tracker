package ru.job4j.tracker;

import ru.job4j.collection.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }

    void getLocalDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyyy HH:mm:ss");
        String currentDateTimeFormat = this.created.format(formatter);
        System.out.println(currentDateTimeFormat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }


    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id);
    }

}