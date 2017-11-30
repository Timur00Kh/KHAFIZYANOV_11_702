package ru.itis;

public class Transport {

    private String name;
    private String number;

    public Transport(String name, String number) {
        setName(name);
        setNumber(number);
    }


    void goIn(ParkingPlace parkingplace) {
        parkingplace.inputCar(this);
    }

    void goOut(ParkingPlace parkingplace) {
        parkingplace.outputCar(this);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number){
        this.number = number;
    }


}