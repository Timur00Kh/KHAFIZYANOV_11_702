package ru.itis;

public class Main {

    public static void main(String[] args) {

        Money m1 = new Money(-10, (byte) -9);
        Money m2 = new Money(0, (byte) 99);

        m2.plus(m1);
        m2.print();

        //ТУТ ВСЕ НЕ ПРАЛЬНА, НО ИДЕЯ ПРИМЕРНО ТАКАЯ
    }
}
