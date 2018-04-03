package ru.itis;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        SomeClass analyzer = new SomeClass();
        analyzer.analyze("X1:=1;");
        LinkedHashMap l = analyzer.process("X1:=200;X2:=2;X3:=X1/X2;");
        System.out.println(l.toString());
    }
}
