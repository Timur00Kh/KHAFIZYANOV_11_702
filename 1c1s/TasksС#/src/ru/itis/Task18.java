package ru.itis;
import java.util.Scanner;

public class Task18 {
    public static void Task18() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = 0;
        for(int i=0; i<4; i++){
            int x = a % 10;
            int y = b % 10;
            if (x == y) k++;
            a /= 10;
            b /= 10;
        }
        System.out.println("Быков:" + k);
    }
}