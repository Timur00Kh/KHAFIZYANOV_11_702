package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    MatrixImpl matrix = new MatrixImpl();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int val = scanner.nextInt();
            matrix.set(x, y, val);
        }

        System.out.println("Введите индексы ячейки, значение которой хотите получить");

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(matrix.get(x, y));
        }
    }
}
