package ru.itis;

import java.time.LocalTime;

public class ParkingPlace {
    private String place;
    private int count = 0;
    private int parkCount = 3;
    private Car[] cars = new Car[parkCount];
    private LocalTime beginTime = LocalTime.parse("00:00:00");
    private LocalTime finishTime = LocalTime.parse("22:00:00");


    public ParkingPlace(String place){
        setPlace(place);
    }

    public void setPlace(String place){
        this.place = place;
    }

    public String getPlace() {
        return place;
    }


    public void parkCar(Car car){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int i = 0;
            count++;
            if (count < cars.length) {
                while (cars[i] != null){
                    i++;
                }
                cars[i] = car;
                car.setParkNumber(i);
                System.out.println(car.getColor() + " " + car.getModel() + " с номером " + car.getNumber() + " заехала на парковку " + getPlace() + " на место " + car.parkNumber);
            } else{
                System.out.println("Парковка переполнена, возвращайтесь в другое время");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }

    public void takeCar(Car car){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int i = 0;
            while (i < cars.length) {
                if (cars[i] == car) {
                    cars[i] = null;
                    count--;
                    System.out.println(car.getColor() + " " + car.getModel() + " с номером " + car.getNumber() + " уехала с парковки " + getPlace() + " под номером " + i);
                    break;
                }
                i++;
            }
            if (i == cars.length) {
                System.out.println("Данный автомобиль не был припаркован");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }
}



