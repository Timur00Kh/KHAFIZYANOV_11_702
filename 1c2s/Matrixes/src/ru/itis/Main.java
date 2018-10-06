package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private final static String PATH = new File("").getAbsolutePath();

    public static void main(String[] args) {
        File file = new File(PATH + "\\files\\step1.txt");
        Object[][] m = null;
        try {
            Scanner scanner = new Scanner(file);
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            m = new Object[height][width];/*(T[][]) new Object[height][width];*/
            int i = 0; int j = 0;
            while (scanner.hasNext()) {
                m[j][i] = scanner.nextInt();
                if (i == width-1) {
                    i = 0;
                    j++;
                }
                else i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        UsualMatrix<Integer> matrix = new UsualMatrix(m);
        matrix.print();
        System.out.println();
        matrix.transpose();
        matrix.print();
    }
}
