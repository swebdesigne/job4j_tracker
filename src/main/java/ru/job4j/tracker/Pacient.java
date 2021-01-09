package ru.job4j.tracker;

public class Pacient extends Doctor {
    private int id;
    private int age;
    private int numberRoom;
    private String diagnosis;
    private String treatment;
    private String namePatient;
    private String surnamePatient;

    public Pacient() {
        this.id = setId();
    }

    public Pacient(int id) {
        Doctor infoPatient = new Doctor();
        Diagnosis diagnosis = new Diagnosis(id);
        Treatment treatment = new Treatment(id);
        this.diagnosis = diagnosis.getDiagnosis();
        this.treatment = treatment.treatment();
        this.numberRoom = infoPatient.getNumberRoom(id);
        this.namePatient = infoPatient.getPatientName(id);
        this.surnamePatient = infoPatient.getPatientSurName(id);
        this.age = infoPatient.getAge(id);
    }

    public int setId() {
        return this.id = 0;
    }

    public static void main(String[] args) {
        Pacient id = new Pacient();
        Pacient patient = new Pacient(id.id);
        System.out.println(
                        "Пациент: " + patient.namePatient
                        + " " + patient.surnamePatient + ", "
                        + "возраст: " + patient.age
                        + "\nПалата № " + patient.numberRoom
                        + "\nЛечащий врач: " + patient.getName()
                        + " (" + patient.getEducation() + ")"
                        + "\nДиагноз: " + patient.diagnosis
                        + "\nЛечение: " + patient.treatment
        );
    }
}
