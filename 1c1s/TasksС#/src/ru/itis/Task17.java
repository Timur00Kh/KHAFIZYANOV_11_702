package ru.itis;

import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите номер билета:");
        int x = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 6; i++) {
            sum1 += x % 10;
            x = x / 10;
            sum2 += x % 10;
            x = x / 10;
        }
        if (Math.abs(sum1 - sum2) == 1) {
            System.out.println("Почти счастливый билет");
        } else {
            System.out.println("Не почти не счастливый билет");
        }
    }
}
