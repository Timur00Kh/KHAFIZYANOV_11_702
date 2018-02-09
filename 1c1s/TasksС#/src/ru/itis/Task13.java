package ru.itis;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Проверка на полиндром:");
        String s = scanner.nextLine();

        int l = s.length() - 1;
        for (int i = 0; i < l/2; i++) {
            char x = s.charAt(i);
            char y = s.charAt(l - i);
            if (x == y) {
                //Почему-то не работает .equals()
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
