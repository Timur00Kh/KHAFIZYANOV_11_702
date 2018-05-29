package ru.itis;

import java.util.Scanner;

public class Main {

    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point p1 = new Point(scanner.nextInt(), scanner.nextInt());
        Point p2 = new Point(scanner.nextInt(), scanner.nextInt());
        Point p3 = new Point(scanner.nextInt(), scanner.nextInt());
        Point v1 = new Point(p1.x-p2.x, p1.y-p2.y);
        Point v2 = new Point(p3.x-p2.x, p3.y-p2.y);

        double answ = ((v1.x * v2.x) + (v1.y * v2.y))/(Math.sqrt(v1.x*v1.x + v1.y*v1.y)*Math.sqrt(v2.x*v2.x + v2.y*v2.y));
        System.out.println(answ);
    }
}
//-2 8 3 2 12 1
//-2 8 3 2 5 6
//-2 8 3 2 5 9