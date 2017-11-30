package ru.itis;
import java.util.Scanner;

public class Task19 {
    public static void Task19() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int a1 = a;
        int b1 = b;
        int k1 = 0;

        for (int i=0; i<4; i++){
            int x = a1 % 10;
            int y = b1 % 10;
            if (x == y) k1++;
            a1 /= 10;
            b1 /= 10;
        }

        int k[] = new int[10];
        int count = 0;
        for(int i = 0; i<4; i++){
            int x = a % 10;
            k[x]++;
            a /= 10;
            x = b % 10;
            k[x]++;
            b /= 10;
        }
        for (int x: k) {
            if (x == 2) count++;
        }

        System.out.println("Коров:" + (count-k1));
    }
}