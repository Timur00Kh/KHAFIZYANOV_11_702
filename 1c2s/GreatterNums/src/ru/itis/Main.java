package ru.itis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ArrayList<Integer> nums = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int l = length(x);
        int nums[] = new int[l];

        for (int i = 0; i < l; i++) {
            nums[i] = x % 10;
            x /= 10;
        }

        reverse(nums);

        int answ = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                if (nums[i] < nums[j]) {
                    answ += factorial(l - i - 1);
                }
            }
        }

        System.out.println(answ);

    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; ++i) f *= i;
        return f;
    }

    public static int[] reverse(int[] input) {
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
        return input;
    }

    public static int length(int x) {
        int k = 0;
        while (x % 10 > 0) {
            k++;
            x /= 10;
        }
        return k;
    }
}
//4267 -> 17