package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    CharacterCounter c = new CharacterCounter();

	    c.analyze(sc.next());
        c.print();
    }
}
