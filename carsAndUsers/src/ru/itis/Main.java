package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] ages = new int[150];

        String path =  new File("").getAbsolutePath();
        File usersFile = new File(path + "\\src\\users.txt");
        File carsFile = new File(path + "\\src\\cars.txt");

        try {
            Scanner userScanner = new Scanner(usersFile);
            Scanner carsScanner = new Scanner(carsFile);

            User user = new User(userScanner.nextInt(), userScanner.next(), userScanner.nextInt());
            Car car = new Car(carsScanner.nextInt(), carsScanner.next(), carsScanner.nextInt());

            while (carsScanner.hasNext()) {
                while (user.id < car.ownerId) user = new User(userScanner.nextInt(), userScanner.next(), userScanner.nextInt());
                if (user.id == car.ownerId) ages[user.age]++;
                car = new Car(carsScanner.nextInt(), carsScanner.next(), carsScanner.nextInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] > 0)System.out.println(i + " "  + ages[i]);
        }

    }
}
