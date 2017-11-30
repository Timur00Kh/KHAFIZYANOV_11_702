package ru.itis;

public class Main {
    public static void main(String[] args) {
        ParkingPlace parking1 = new ParkingPlace("P01");
        ParkingPlace parking5 = new ParkingPlace("P02");
        Car car1 = new Car("Kopeika", "true black", 903);
        Car car5 = new Car("Lada Kalina", "really blue", 313);
        Car car6 = new Car("Mitsubishi ASX", "very silver", 822);
        car1.toPark(parking1);
        car5.toPark(parking5);
        car6.toPark(parking5);
        car1.toTake(parking1);
        car6.toTake(parking1);
        car6.toPark(parking5);

    }
}
