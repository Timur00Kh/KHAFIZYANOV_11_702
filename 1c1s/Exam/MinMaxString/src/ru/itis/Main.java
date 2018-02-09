package ru.itis;

public class Main {

    public static void main(String[] args) {
        String minString = "";
        String maxString = "";

        String s[] = {"АБАК", "АБРАКАДАБРА", "А"};

//        for (int i = 1; i < args.length - 1; i++) {
//            minString = minimal(args[i], args[i+1]);
//            maxString = maximal(args[i], args[i+1]);
//        }

        for (int i = 1; i < s.length - 1; i++) {
            minString = minimal(s[i], s[i+1]);
            maxString = maximal(s[i], s[i+1]);
        }

        System.out.println(minString);
        System.out.println(maxString);
    }

    public static String minimal(String s1, String s2) {
        for (int i = 0; i < min(s1.length(),s2.length()) - 1; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return s1;
            }
        }
        if (s1.length() < s2.length()) {
            return s1;
        } else return s2;
    }

    public static String maximal(String s1, String s2) {
        for (int i = 0; i < min(s1.length(),s2.length()) - 1; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return s1;
            }
        }
        if (s1.length() > s2.length()) {
            return s1;
        } else return s2;
    }

    public static int min(int x, int y) {
        if (x < y) {
            return x;
        } else return y;
    }
}
