package ru.itis;
import java.util.Scanner;

public class Task20 {
    public static void Task20() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите перове число");
        int number1 = scanner.nextInt();
        System.out.println("Введите второе число");
        int number2 = scanner.nextInt();
        int number3 = 0;
        for (int i =0; i <6; i++){
            int k=0;
            k = (number1 % 10 + number2 % 10) % 10;
            number1 /= 10;
            number2 /= 10;
            number3 *= 10;
            number3 += k;
        }

        int sum1 = 0;
        int sum2 = 0;

        for (int i=0; i<3; i++){
            sum1 += number3 % 10;
            number3 /= 10 ;
        }

        for (int i=0; i<3; i++){
            sum2 += number3 % 10;
            number3 /= 10;
        }

        if (sum1 == sum2) {
            System.out.println("YEAY");
        } else {
            System.out.println("NO GOD PLEASE, No, NOOOOOOOOOOOO");
        }
    }
}