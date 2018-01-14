package ru.itis;

public class Main {

    public static void main(String[] args) {
	    RatFrac r = new RatFrac(4, 1, 2);
	    RatFrac r2 = new RatFrac(2, 1, 2);
        r.subtract(r2);
	    r.print();
    }
}
