package ru.itis;

public class MyDot {
    public int x;
    public int y;
    public boolean isRemoved = false;

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

    public boolean isGreaterEqual(MyDot dot) {
        if (this.x >= dot.x) {
            if (this.y >= dot.y) return true;
        }
        return false;
    }

    public void remove() {
        this.isRemoved = true;
    }
}
