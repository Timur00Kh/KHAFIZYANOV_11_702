package ru.itis;

public class Main {

    public static void main(String[] args) {
        String s1 = new StringBuffer("12345").reverse().toString();
        String s2 = new StringBuffer("12345").reverse().toString();

        System.out.println(sum(s1,s2));
    }

    public static String sum(String a, String b) {
        if (b.length() < a.length()) {
            String c = b;
            b = a;
            a = c;
        }

        int i = a.length();
        int k = 0;
        String s = "";
        int t = 0;
        while (k < i) {
            int c = whatTheInt(a.charAt(k)) + whatTheInt(b.charAt(k));
            c += t;
            if (c >= 10) {
                t = c / 10;
                c %= 10;
            } else t = 0;
            s += String.valueOf(c);
            k++;
        }
        s = new StringBuffer(s).reverse().toString();
        return s;
    }

    public static int whatTheInt(char c){
        int i = c - '0';
        return i;
    }
}
