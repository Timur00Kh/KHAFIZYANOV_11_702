package ru.itis;

public class Figure {
    protected  double square;
    protected  double perimetr;
    public Figure(){
        this.perimetr = perimetr();
        this.square = square();
    }

    public double perimetr() {
        return 0;
    }

    public double square() {
        return 0;
    }
}