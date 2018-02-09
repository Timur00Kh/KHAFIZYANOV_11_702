package ru.itis;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите коэффициенты(a, b, c):");
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();

        double d = Math.sqrt(b * b - 4 * a * c);
        if (d == 0) {
            System.out.println("Кол-во корней: 1");
            double x1 = -b / 2*a;
            System.out.println("x1 = " + x1);
            return;
        }
        if (d > 0) {
            System.out.println("Кол-во корней: 2");
            double x1 = (-b + d) / 2*a;
            double x2 = (-b - d) / 2*a;
            System.out.println("x1 = " + x1 + "\nx2 = " + x2);
            return;
        }
        System.out.println("D меньше нуля");
    }
}
