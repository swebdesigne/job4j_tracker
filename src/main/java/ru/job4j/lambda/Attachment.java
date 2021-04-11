package ru.job4j.lambda;

import java.util.*;

public class Attachment {
    private String name;
    private int size;

    public Attachment(String name) {
        this.name = name;
    }

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Attachment{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attachment name = (Attachment) o;
        return Objects.equals(name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
           new Attachment("images 1", 100),
           new Attachment("images 2", 34),
           new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        ArrayList<Integer> list = new ArrayList<Integer>() {
            @Override
            public boolean add(Integer o) {
                System.out.println("Add a new element to list: " + o);
                return super.add(o);
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        list.add(100500);

        Comparator<Attachment> equalsName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        System.out.println(
                equalsName.compare(
                    new Attachment("Alina"),
                    new Attachment("Igor")
                )
        );
    }
}
