package ru.itis;

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты координаты и радиус(x, y, r):");
        double x1 = scanner.nextInt();
        double y1 = scanner.nextInt();
        double r1 = scanner.nextInt();
        System.out.println("Введите координаты координаты и радиус(x, y, r):");
        double x2 = scanner.nextInt();
        double y2 = scanner.nextInt();
        double r2 = scanner.nextInt();

        double l = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        if (l < r1 + r2) {
            System.out.println("YES");
            return;
        }
        System.out.println("No");
    }
}

