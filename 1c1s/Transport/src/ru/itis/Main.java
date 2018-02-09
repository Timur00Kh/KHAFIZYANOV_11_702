package ru.itis;

public class Main {

    public static void main(String[] args) {
        ParkingPlace parking1 = new ParkingPlace("P01");
        Car car1 = new Car("Kopeika", 10);
        Car car5 = new Car("Lada Kalina", 13);
        Car car6 = new Car("Mitsubishi ASX", 22);
        TractorBelarus tr1 = new TractorBelarus("PotatoVoz", 33, 150);

        car1.toPark(parking1);
        car5.toPark(parking1);
        car6.toPark(parking1);
        car1.toTake(parking1);
        car6.toTake(parking1);
        car6.toPark(parking1);
        car5.toTake(parking1);
        tr1.toPark(parking1);

        ParkingPlace p2 = new ParkingPlace("P02");
        Plane plane1 = new Plane("Иж 21", 100, "Moscow");

        plane1.toPark(p2);
        plane1.toMove(100);
        plane1.toTake(p2);
        plane1.toMove(10);
        plane1.toMove(150);
    }
}
