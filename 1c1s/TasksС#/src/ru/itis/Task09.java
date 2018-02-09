package ru.itis;

import java.util.Scanner;
import java.util.Formatter;

public class Task09 {
    public static void main(String[] args) { // не работает с 0
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите коэффициенты(a, b, c):");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        Formatter s = new Formatter();
        s.format("%dx^2%+dx", a, b);
        String str = s.toString();
        str = str.replace("0","");
        str = str.replace("1","");
        System.out.printf(str + "%+d", c);
    }
    public static void main2(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a != 0) {
            if (a == 1) System.out.print("x^2");
            if (a == -1) System.out.print("-x^2");
            if (a != 1 && a != -1) System.out.print(a + "x^2");
        }
        if (b != 0) {
            if (b<0) {
                if (b == -1) System.out.print("-x");
                else System.out.print(b + "x");
            } else
            if (b == 1) System.out.print("x");
            else System.out.print("+" + b + "x");
        }
        if (c != 0) {
            if (c<0) {
                System.out.print(c);
            } else System.out.print("+" + c);
        }
    }
}
