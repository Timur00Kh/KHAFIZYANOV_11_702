package ru.itis;

public class MatrixCell {
    int i;
    int j;
    int value;

    MatrixCell(int a, int b, int c) {
        this.i = a;
        this.j = b;
        this.value = c;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getValue() {
        return value;
    }

    public void  print() {
        System.out.println("");
    }
}
