package ru.itis;

public class Main {

    public static void main(String[] args) {
        ParkingPlace parking = new ParkingPlace();
        Transport car = new Car("mashina", "234");
        Transport plane = new Plane("camolet", "432");
        Transport sportcar = new Sportcar("sportkar", "758");
        Transport tank = new Tank("tank", "432");
        Transport traktorbelarus = new TraktorBelarus("traktorbelarus", "647", 534);
        car.goIn(parking);
        plane.goIn(parking);
        sportcar.goIn(parking);
        tank.goIn(parking);
        traktorbelarus.goIn(parking);
        plane.goOut(parking);
        car.goOut(parking);
        traktorbelarus.goOut(parking);
    }
}