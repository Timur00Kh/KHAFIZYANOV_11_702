package ru.itis;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        String s = new String(scanner.nextLine());
        int x = scanner.nextInt();

        Figures figures = new Figures();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') figures.add(new Figure(s.charAt(i) - '0'));
        }
        System.out.println();
        solve(figures, x, s);

    }

    public static Figure[] solve(Figures n, int x, String y) throws FileNotFoundException {
        int itr = 0;
        int maxItr = 9;
        for (int i = 0; i < n.getSize() - 1; i++) {
            maxItr = maxItr * 10 + 9;
        }

        while (itr < maxItr + 1) {
            int itrs[] = new int[n.getSize()];
            int tempItr = itr;
            int matches = 0;
            for (int i = 0; i < n.getSize(); i++) {
                itrs[i] = tempItr % 10;
                tempItr /= 10;
            }
            itrs = reverse(itrs);
            int maxSteps = n.calcSteps(itrs);


            if (validate(itrs, y)) {
                itr++;
                continue;
            }

            for (int i = 0; i < n.getSize(); i++) {
                matches += n.get(i).matches[itrs[i]];
                maxSteps += n.get(i).steps2[itrs[i]];
            }

            if (matches == 0 && maxSteps == x) {
                    System.out.println(stringify(itrs, y));
            }

            itr++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Со сменой знака?");
        if (scanner.nextInt() == 1 && (y.indexOf("+") > 0 || y.indexOf("-") > 0)) solveEx(n, x, y);
        System.out.println(itr);
        return null;
    }

    public static Figure[] solveEx(Figures n, int x, String y) throws FileNotFoundException {
        int itr = 0;
        int maxItr = 9;
        int znak  = 0;
        for (int i = 0; i < n.getSize() - 1; i++) {
            maxItr = maxItr * 10 + 9;
        }
        if (y.indexOf("+") > 0) {
            y = y.replace('+', '-');
            znak = 1;
        } else if (y.indexOf("-") > 0) {
            y = y.replace('-', '+');
            znak = -1;
        }
        while (itr < maxItr + 1) {
            int itrs[] = new int[n.getSize()];
            int tempItr = itr;
            int matches = 0;
            for (int i = 0; i < n.getSize(); i++) {
                itrs[i] = tempItr % 10;
                tempItr /= 10;
            }
            itrs = reverse(itrs);
            int maxSteps = n.calcSteps(itrs);


            if (validate(itrs, y)) {
                itr++;
                continue;
            }

            for (int i = 0; i < n.getSize(); i++) {
                matches += n.get(i).matches[itrs[i]];
                maxSteps += n.get(i).steps2[itrs[i]];
            }
            matches += znak;

            if (matches == 0 && maxSteps == x) {
                    System.out.println(stringify(itrs, y));
            }

            itr++;
        }
        System.out.println(itr);
        return null;
    }

    public static boolean validate(int n[], String y) {
        int components[] = {0, 0, 0};
        char operator = ' ';
        int k = 0;
        int k2 = 0;

        for (int i = 0; i < y.length(); i++) {
             if (y.charAt(i) <= '9' && y.charAt(i) >= '0') {
                components[k2] = components[k2] * 10 + n[k];
                k++;
            }
            if (i == 0) continue;
            if (y.charAt(i - 1) <= '9' && y.charAt(i - 1) >= '0' && (y.charAt(i) > '9' || y.charAt(i) < '0')) k2++;
            if (y.charAt(i) == '+' || y.charAt(i) == '-' || y.charAt(i) == '*') operator = y.charAt(i);
        }

        if (operator == '+' && components[0] + components[1] == components[2]) return false;
        if (operator == '-' && components[0] - components[1] == components[2]) return false;
        if (operator == '*' && components[0] * components[1] == components[2]) return false;
        return true;
    }

    public static String stringify(int n[], String y) {
        String s = "";
        int k = 0;
        for (int i = 0; i < y.length(); i++) {
            if (y.charAt(i) <= '9' && y.charAt(i) >= '0') {
                s += Integer.toString(n[k]);
                k++;
            }
            else {
                s += (char) y.charAt(i);
            }
        }
        return s;
    }

    public static int[] reverse(int[] input) {
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
        return input;
    }
}