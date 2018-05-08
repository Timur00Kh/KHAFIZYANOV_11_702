package ru.itis;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Timur Kh\\Desktop\\KHAFIZYANOV_11_702\\GrathRestructurer\\files\\file.txt");
        Graph graph = new Graph();
        graph.readGraph(file);
        graph.restructure();
        graph.print();
    }
}
