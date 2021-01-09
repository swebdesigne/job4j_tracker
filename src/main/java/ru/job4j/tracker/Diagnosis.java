package ru.job4j.tracker;

public class Diagnosis extends Doctor {
    private String diagnosis;

    public Diagnosis(int val) {
        String[] array = {"ушиб", "порез", "вывих"};
        this.diagnosis = array[val];
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }
}
