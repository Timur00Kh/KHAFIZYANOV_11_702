package ru.itis;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите номер билета:");
        int x = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 3; i++) {
            sum1 += x % 10;
            x = x / 10;
        }
        for (int i = 0; i < 3; i++) {
            sum2 += x % 10;
            x = x / 10;
        }
        if (sum1 == sum2) {
            System.out.println("Yes");
        } else {
            System.out.println("no no no no no no");
        }
    }
}
