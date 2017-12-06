package ru.itis;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        int k = 50;
        int[] x = {100, 100 + k, 230 - k, 240 + k, 300, 380 - k};
        int[] y = {200 + k, 312, 347, 495, 450 + k, 603};
        double a = (float) (6 * two(x, y) - one(x) * one(y)) / (6 * onesqr(x) - one(x) * one(x));
        double b = (float) (one(y) * onesqr(x) - two(x, y) * one(x)) / (6 * onesqr(x) - one(x) * one(x));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        double ychert = (float) one(y) / 6;
        double r1 = (double) (ychertfunk(y, ychert) - yvol(x, y, a, b)) / ychertfunk(y, ychert);
        double r = Math.sqrt(r1);
        System.out.println("r = " + r);
    }

    public static double ychertfunk(int[] y, double ychert) {
        double sum = 0;
        for (int i = 0; i < 6; i++) {
            sum = sum + (y[i] - ychert) * (y[i] - ychert);
        }
        return sum;
    }

    public static int two(int[] x, int[] y) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum = sum + (x[i] * y[i]);
        }
        return sum;
    }

    public static int one(int[] a) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    public static int onesqr(int[] a) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum = sum + (a[i] * a[i]);
        }
        return sum;
    }

    public static double yvol(int[] x, int[] y, double a, double b) {
        double sum = 0;
        for (int i = 0; i < 6; i++) {
            sum = sum + (y[i] - (x[i] * a + b)) * (y[i] - (x[i] * a + b));
        }
        return sum;
    }
}


