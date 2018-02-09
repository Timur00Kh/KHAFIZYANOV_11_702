package ru.itis;

public class Rectangle {
    double x1;
    double x2;
    double x3;
    double x4;
    double y1;
    double y2;
    double y3;
    double y4;

    public Rectangle(double x1, double y1, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x1;
        this.x3 = x3;
        this.x4 = x3;
        this.y1 = y1;
        this.y2 = y3;
        this.y3 = y3;
        this.y4 = y1;
    }

//    public Rectangle(Rectangle r1, Rectangle r2) {
//        double x
//        if (r1.x1 < r2.x1) {
//
//        }
//    }

    public void move(double x, double y) {
        this.x1 += x;
        this.x2 += x;
        this.x3 += x;
        this.x4 += x;
        this.y1 += y;
        this.y2 += y;
        this.y3 += y;
        this.y4 += y;
    }

    public void scale(double x, double y) {
        this.x3 *= x;
        this.y3 *= y;
        this.x4 = this.x3;
        this.y2 = this.y3;
    }

    public void scale(double x) {
        this.x3 *= x;
        this.y3 *= x;
        this.x4 = this.x3;
        this.y2 = this.y3;
    }

    public void newRectangle(Rectangle r) {
        if (this.x1 > r.x1) {
            this.x1 = r.x1;
        }
        if (this.y1 > r.y1) {
            this.y1 = r.y1;
        }
        if (this.x3 < r.x3) {
            this.x3 = r.x3;
        }
        if (this.y3 < r.y3) {
            this.y3 = r.y3;
        }
        this.x2 = x1;
        this.y2 = y3;
        this.x4 = x3;
        this.y4 = y1;
    }

    public void print() {
        System.out.println("x1= " + this.x1 + " y1= " + this.y1);
        System.out.println("x2= " + this.x2 + " y2= " + this.y2);
        System.out.println("x3= " + this.x3 + " y3= " + this.y3);
        System.out.println("x1= " + this.x4 + " y1= " + this.y4);
        System.out.println("===========");
    }
}
