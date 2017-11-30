package ru.itis;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты точки a(0 1):");
        double x1 = scanner.nextInt();
        double y1 = scanner.nextInt();
        System.out.println("Введите координаты точки b(1 -4):");
        double x2 = scanner.nextInt();
        double y2 = scanner.nextInt();
        System.out.println("Введите координаты точки c(5 2):");
        double x3 = scanner.nextInt();
        double y3 = scanner.nextInt();

        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double b = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        double c = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println(s);
    }
}