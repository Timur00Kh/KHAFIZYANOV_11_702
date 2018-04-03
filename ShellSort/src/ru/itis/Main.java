package ru.itis;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        Generator generator = new Generator();
//        generator.generate("file5", 1000);
        FileAssistant fileAssistant = new FileAssistant();
        int[][] arrays = fileAssistant.getArraysFromFile("file4.txt");

        for (int i = 0; i < arrays.length; i++) {
            long time = System.nanoTime();
            ShellSorter.sort(arrays[i]);
            time = System.nanoTime() - time;
            //здесь будет экспорт в эксель
            fileAssistant.writeExelLine(time, ShellSorter.getLastNumberOfIterations(), arrays[i].length);
            System.out.println("Затрачено " + time + " nanoTime.");
            System.out.println("Количество итераций: " + ShellSorter.getLastNumberOfIterations());
            System.out.println("Количество чисел: " + arrays[i].length);
            System.out.println("=============================");
        }

        fileAssistant.closeExelFile();

        /*for (int i = 0; i < 100; i++) {
            Random random = new Random();
            System.out.println(random.nextInt(10000));
        }*/
    }
}
