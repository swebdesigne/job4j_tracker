package ru.job4j.tracker;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private short birthday;

    public Profession(String name, String surname, String education, short birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getEducation() {
        return education;
    }

    public short getBirthday() {
        return birthday;
    }

}
