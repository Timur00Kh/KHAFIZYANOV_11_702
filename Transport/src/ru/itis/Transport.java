package ru.itis;

public abstract class Transport {
    protected int fuelFlow; //расход топлива на километр
    protected ParkingPlace parkingPlace;
    protected String name;
    protected int parkNumber = -1;
    protected int move = 0;

    public Transport(String name, int fuelFlow){
        this.name = name;
        this.fuelFlow = fuelFlow;
        this.setParkNumber(-1);
        //this.consumption = 0;
    }


    public void toPark(ParkingPlace parkingPlace){
        parkingPlace.parkCar(this);
    }
    public void toTake(ParkingPlace parkingPlace) {
        parkingPlace.takeCar(this);
    }

    public int getFuelFlow() {
        return fuelFlow;
    }

    public ParkingPlace getParkingPlace() {
        return parkingPlace;
    }

    public String getName() {
        return name;
    }

    public void setParkNumber(int parkNumber) {
        this.parkNumber = parkNumber;
    }

    public int getPotato(){return 0;}
    public String getDestination(){return "";}

    public void toMove(int move) {
        if (this.parkNumber == -1) {

            if (move <= this.fuelFlow) {
                this.fuelFlow -= move;
                System.out.println(this.getName() + " проехал(а) " + move + " км");
            } else {
                System.out.println("Недостаточно топлива");
            }
        } else System.out.println("Сначала надо выехать с парковки");
    }
}
