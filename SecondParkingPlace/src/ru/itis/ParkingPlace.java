package ru.itis;
import java.time.LocalTime;

public class ParkingPlace {
    private int hour;
    private final int capacity = 20;
    private int free = capacity;
    private boolean ability;
    private Transport[] cars = new Transport[capacity];

    LocalTime time = LocalTime.now();
    public ParkingPlace() {

    }

    void inputCar(Transport transport) {
        setAbility();
        if (ability) {
            if (free == 0) {
                System.err.println("Нет места в парковке");
            } else {
                for (int i = 0; i < capacity; i++){
                    if (cars[i] == null) {
                        cars[i] = transport;
                        System.out.println("Ваше место:" + i);
                        break;
                    }
                }
                --free;
            }
        } else {
            System.err.println("Не работает");
        }
    }

    void outputCar(Transport transport) {
        setAbility();
        if (ability) {
            for (int i = 0; i < capacity; i++) {
                if (cars[i] == transport) {
                    System.out.println("Ваше место было:" + i);
                    System.out.println("Имя траспорта: " + transport.getName());
                    System.out.println("Номер траспорта: " + transport.getNumber());
                    if (cars[i].getClass() == TraktorBelarus.class) {
                        TraktorBelarus.showPotato();
                    }
                    System.out.println("До свидания!");
                    cars[i] = null;

                    break;
                }
            }
            ++free;

        } else {
            System.err.println("Не работает");
        }

    }


    public void setAbility() {
        hour = time.getHour();
        // System.out.println("Сейчас время: " + hour);
        if (hour > 7 && hour < 22) {
            this.ability = true;
        } else {
            this.ability = false;
        }
    }
}

