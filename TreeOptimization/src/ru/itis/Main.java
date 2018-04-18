package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int k = sc.nextInt();
	    sc.close();
        System.out.println("========");
        int nodeAmount = 0;
        int levelNodeAmount = n;
        int mod = 0;
        while (levelNodeAmount > 1) {
            mod += levelNodeAmount % k;
            levelNodeAmount = levelNodeAmount / k;
            nodeAmount += levelNodeAmount;
        }
        if (mod <= k) {
            nodeAmount += 2;
        } else {

        }
        System.out.println(nodeAmount);
//        System.out.println(mod);
    }
}
