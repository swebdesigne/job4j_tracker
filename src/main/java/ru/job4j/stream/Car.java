package ru.job4j.stream;

public class Car {
    private String company;
    private String modal;
    private byte tank;
    private byte door;
    private float maxSpeed;
    private float fuelConsumption;
    private String color;

    static class Builder {
        private String company;
        private String modal;
        private byte tank;
        private byte door;
        private float maxSpeed;
        private float fuelConsumption;
        private String color;

        Builder buildCompany(String company) {
            this.company = company;
            return this;
        }

        Builder buildModal(String modal) {
            this.modal = modal;
            return this;
        }

        Builder buildTank(byte tank) {
            this.tank = tank;
            return this;
        }

        Builder buildDoor(byte door) {
            this.door = door;
            return this;
        }

        Builder buildMaxSpeed(float maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildFuelConsumption(float fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.company = company;
            car.modal = modal;
            car.tank = tank;
            car.door = door;
            car.maxSpeed = maxSpeed;
            car.fuelConsumption = fuelConsumption;
            car.color = color;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "company='" + company + '\''
                + ", modal='" + modal + '\''
                + ", tank=" + tank
                + ", door=" + door
                + ", maxSpeed=" + maxSpeed
                + ", fuelConsumption=" + fuelConsumption
                + ", color='" + color + '\''
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder().buildCompany("Nissan")
                .buildModal("X Trail")
                .buildColor("black")
                .buildDoor((byte) 5)
                .buildFuelConsumption(80F)
                .buildMaxSpeed(200F)
                .buildTank((byte) 60)
                .build();
        System.out.println(car);
    }
}
