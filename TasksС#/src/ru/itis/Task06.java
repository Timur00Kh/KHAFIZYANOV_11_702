package ru.itis;

import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год:");
        int x = scanner.nextInt();

        if ((x <= 1) || (x >= 9999)) {
            System.out.println("ERROR: Не корректный год");
            return;
        }
        System.out.println("День программиста празнуется:");
        if (x % 4 == 0 && x % 100 != 0 || x % 400 == 0){
            System.out.printf("12/09/%04d", x);
        } else {
            System.out.printf("13/09/%04d", x);
        }
    }
}
