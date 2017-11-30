package ru.itis;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты клетки(h 8):");
        int x = scanner.next().charAt(0) - 'a' + 1;
        int y = scanner.nextInt();

        System.out.println("У клетки цвет:");
        if ((x % 2 != 0)) {
            if (y % 2 != 0) {
                System.out.println("Black");
            } else {
                System.out.println("White");
            }
        } else {
            if (y % 2 != 0) {
                System.out.println("White");
            } else {
                System.out.println("Black");
            }
        }
    }

}
