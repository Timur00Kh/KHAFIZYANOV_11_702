package ru.itis;

public class Pixel {
    int r = 0;
    int g = 0;
    int b = 0;

    public Pixel(int a, int x, int c) {
        this.r = a;
        this.g = x;
        this.b = c;
    }

    public void ptint() {
        System.out.println(this.r + " " + this.g + " " + this.b);
    }
}
