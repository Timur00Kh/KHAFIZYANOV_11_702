package ru.itis;

public class Main {

    public static void main(String[] args) {
	    MyHashMap<String, Integer> map = new MyHashMap<>();

	    map.set("A", 1);
	    map.set("B", 2);
	    map.set("C", 3);
	    map.set("D", 4);
	    map.set("E", 5);
	    map.set("F", 6);
	    map.set("g", 6);
	    map.set("e", 6);
	    map.set("U", 6);
	    map.set("U", 8);
	    map.set("U", 9);

		System.out.println(map.get("U"));
		System.out.println(map.get("1"));

	    int t = 0;
    }
}
