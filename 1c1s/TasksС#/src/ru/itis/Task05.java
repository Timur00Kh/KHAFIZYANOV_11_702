package ru.itis;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты клетки(h 8):");
        int x1 = scanner.next().charAt(0) - 'a' + 1;
        int y1 = scanner.nextInt();
        System.out.println("Введите координаты второй клетки:");
        int x2 = scanner.next().charAt(0) - 'a' + 1;
        int y2 = scanner.nextInt();

        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            System.out.println("SAME");
            return;
        }
        if (Math.abs(Math.abs(x1 - x2) - Math.abs(y1 - y2)) == 1) {
            System.out.println("NEIGHBOUR");
            return;
        }
        System.out.println("Not NEIGHBOUR; Not SAME");
    }
}
