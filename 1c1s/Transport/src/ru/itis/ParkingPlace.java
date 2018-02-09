package ru.itis;

import java.time.LocalTime;

public class ParkingPlace{
    private String place;
    private int count = 0;
    private int parkCount = 2;
    private Transport[] transports = new Transport[parkCount];
    private LocalTime beginTime = LocalTime.parse("00:00:00");
    private LocalTime finishTime = LocalTime.parse("22:00:00");
    private int potatoCount = 0;
    private String comment;

    public int getCount() {
        return count;
    }

    public ParkingPlace(String place){
        setPlace(place);
    }

    public void setPlace(String place){
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void parkCar(Transport transport){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int i = 0;
            if (count < transports.length) {
                count++;
                while (transports[i] != null){
                    i++;
                }
                transports[i] = transport;
                transport.setParkNumber(i);
                System.out.println(transport.getName() + " заехал(а) на парковку " + this.getPlace() +  " на место " + i + addComment(transport));
            } else{
                System.out.println("Парковка переполнена, возвращайтесь в другое время");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }

    public void takeCar(Transport transport){
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            int i = 0;
            while (i < transports.length) {
                if (transports[i] == transport) {
                    transports[i] = null;
                    count--;
                    System.out.println(transport.getName()  + " уехал(а) с парковки " + this.getPlace() + " с места под номером " + i + addComment(transport));
                    transport.setParkNumber(-1);
                    break;
                }
                i++;
            }
            if (i == transports.length) {
                System.out.println("Данный автомобиль не был припаркован");
            }
        } else {
            System.out.println("Парковка не работает, возвращайтесь в другое время");
        }
    }

    public String addComment(Transport transport) {
        if (transport.getClass() == TractorBelarus.class) {
            comment = " C " + transport.getPotato() + " кг картошки ";
            return comment;
        }
        if (transport.getClass() == Plane.class) {
            comment = ". Он направляется в " + transport.getDestination();
            return comment;
        }
        return "";
    }
}