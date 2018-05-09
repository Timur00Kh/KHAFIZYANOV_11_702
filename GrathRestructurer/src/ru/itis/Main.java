package ru.itis;

import java.io.File;

public class Main {

    public static final String PATH = new File("").getAbsolutePath();

    public static void main(String[] args) {
        File file = new File(PATH + "\\files\\file2.txt");
        Graph graph = new Graph();
        graph.readGraph(file);
        graph.restructure();
        graph.print();
        System.out.println("\n" + graph.toString());
    }
}
