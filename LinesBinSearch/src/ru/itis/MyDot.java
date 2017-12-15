package ru.itis;

public class MyDot {
    public int x;
    public int y;
    public boolean isNotRemoved = true;

    public MyDot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreater(MyDot dot) {
        if (this.x > dot.x) {
            return true;
        }
        if (this.x == dot.x) {
            if (this.y > dot.y) return true;
        }
        return false;
    }

    public boolean isGreaterOrEqual(MyDot dot) {
        if (this.x > dot.x) {
            return true;
        }
        if (this.x == dot.x) {
            if (this.y >= dot.y) return true;
        }
        return false;
    }

    public void remove() {
        this.isNotRemoved = false;
    }

    public void print() {
        System.out.println("x = " + this.x + " " + "y = " + this.y);
    }
}
