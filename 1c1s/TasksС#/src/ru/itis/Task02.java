package ru.itis;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {
        System.out.println("Программа вычисляющая, возможен ли ход пешкой не учитывая расположения другич фигур(без проверки на дурака)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты пешки(h 8):");
        int x1 = scanner.next().charAt(0) - 'a' + 1;
        int y1 = scanner.nextInt();
        System.out.println("Введите координаты хода:");
        int x2 = scanner.next().charAt(0) - 'a' + 1;
        int y2 = scanner.nextInt();

        if ((y2 - y1== 1) && (x1 == x2)){
            System.out.println("Ход возможен!");
            return;
        }
        if (y1 == 2 && y2 - y1 == 2 && x1 == x2) {
            System.out.println("Ход возможен!");
            return;
        }
        System.out.println("Ход не возможен!");
    }
}
