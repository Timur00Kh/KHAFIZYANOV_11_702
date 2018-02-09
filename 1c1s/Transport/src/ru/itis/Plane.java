package ru.itis;

public class Plane extends  Transport {
    private String destination;

    public Plane(String name, int fuelFlow, String destination){
        super(name, fuelFlow);
        this.destination = destination;
    }

    @Override
    public String getDestination() {
        return destination;
    }
}
