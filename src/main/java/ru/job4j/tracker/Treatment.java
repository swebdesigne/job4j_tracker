package ru.job4j.tracker;

public class Treatment {
    private String treatment;

    public Treatment(int val) {
        String[] array = {"Фастумгель", "Гирудалгон", "Лиотон"};
        this.treatment = array[val];
    }

    public String treatment() {
        return this.treatment;
    }
}
