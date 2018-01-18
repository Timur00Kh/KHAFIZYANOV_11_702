package ru.itis;

public class Main {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(0, 0, 3,3);
        Rectangle r1 = new Rectangle(1,1,3,3);
        Rectangle r2 = new Rectangle(2,2,4,4);
        r.print();
        r.move(1, 1);
        r.print();
        r.scale(2);
        r.print();
        r1.newRectangle(r2);
        r1.print();
    }
}
