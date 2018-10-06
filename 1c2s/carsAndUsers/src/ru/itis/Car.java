package ru.itis;

public class Car {
    int id;
    String model;
    int ownerId;

    public Car(int id, String model, int ownerId) {
        this.id = id;
        this.model = model;
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
