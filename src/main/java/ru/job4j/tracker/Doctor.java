package ru.job4j.tracker;

public class Doctor extends Profession {
    private String historyDisease;
    private String pacientName;
    private int[] numberRoom;
    private String dutySchedule;
    private int experience;

    public Doctor() {
        super("Игорь", "Петрович", "хирург", (short) 33);
    }

    public String getPatientName(int val) {
        String[] array = {"Петр", "Аня", "Иван"};
        return pacientName = array[val];
    }

    public String getPatientSurName(int val) {
        String[] array = {"Иванов", "Петров", "Сидоров"};
        return array[val];
    }

    public int getAge(int val) {
        int[] array = {19, 32, 43};
        return array[val];
    }

    public int getNumberRoom(int val) {
        int[] array = {1, 2, 3};
        return array[val];
    }

    public String getDutySchedule() {
        return this.dutySchedule;
    }
}
