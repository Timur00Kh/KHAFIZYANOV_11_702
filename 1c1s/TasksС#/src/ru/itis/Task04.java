package ru.itis;

import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты ладьи(h 8):");
        int x1 = scanner.next().charAt(0) - 'a' + 1;
        int y1 = scanner.nextInt();
        System.out.println("Введите координаты хода:");
        int x2 = scanner.next().charAt(0) - 'a' + 1;
        int y2 = scanner.nextInt();

        if (x1 - x2 == 0 || y1 - y2 == 0) {
            System.out.println("Ход возможен!");
            return;
        }
        System.out.println("Ход не возможен!");
    }
}
