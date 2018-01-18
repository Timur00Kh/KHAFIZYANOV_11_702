package ru.itis;

public class Main {

    public static void main(String[] args) {
        String s[] = {"a", "b", "c", "d", "e", "f", "g"};

        System.out.println(stringBinSearch(s, 0, 6, "a"));

    }

    public static int stringBinSearch(String s[], int lower, int higher, String x) {
        int mid = lower + (higher - lower) / 2;

        if (x.equals(s[mid])) {
            return mid;
        }
        if (higher - 1 == lower) {
            if (x.equals(s[higher])) {
                return higher;
            }
            if (x.equals(s[lower])) {
                return lower;
            }
            return -1;
        }
        if (x.compareTo(s[mid]) > 0) {
            return stringBinSearch(s, mid, higher, x);
        }
        if (x.compareTo(s[mid]) < 0) {
            return stringBinSearch(s, lower, mid, x);
        }
        return -1;
    }
}
