package ru.itis;

public class Car {
    private String model;
    private String color;
    private int number;
    int parkNumber = -1;

    public Car(String model, String color, int number){
        setColor(color);
        setModel(model);
        setNumber(number);
    }

    public void toPark(ParkingPlace parkplace){
        parkplace.parkCar(this);
    }
    public void toTake(ParkingPlace parkplace){
       parkplace.takeCar(this);
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getColor() {
        return color;
    }
    public String getModel() {
        return model;
    }
    public int getNumber() {
        return number;
    }

    public void setParkNumber(int parkNumber) {
        this.parkNumber = parkNumber;
    }
}
