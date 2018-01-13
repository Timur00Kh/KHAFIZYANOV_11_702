package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\Timur Kh\\Desktop\\KHAFIZYANOV_11_702\\Image16x\\src\\input.txt");
        Scanner scanner = new Scanner(input);

        Image image = new Image();

        while(scanner.hasNext()){
            image.setPixel(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        Image rImage = image.getRComponent();
        rImage.print();
    }
}
