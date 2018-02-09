package ru.itis;

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("стороны треугольника(a, b, c):");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if ((a < b +c) && (b < a + c) && (c < a + b)){
            System.out.println("YES");
            return;
        }
        System.out.println("No");
    }
}
