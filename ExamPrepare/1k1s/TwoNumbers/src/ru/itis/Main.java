package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src\\input.txt");
        Scanner scanner = new Scanner(input);
        int count = 0;

        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if (isRequired(n)) count++;
            if (count > 2) {
                System.out.println("Таких чисел больше двух");
                break;
            }
            System.out.println(n + " " + isRequired(n));
        }
        if (count == 2) {
            System.out.println("Таких чисел ровно два");
        } else {
            System.out.println("Что-то пошло не так");
        }

    }

    public static boolean isRequired(int x) {
        int k = x % 2;
        while (x % 10 > 0) {
            if (x % 2 == k) {
                x = x / 10;
            } else {
                return false;
            }
        }
            return true;
    }

}
