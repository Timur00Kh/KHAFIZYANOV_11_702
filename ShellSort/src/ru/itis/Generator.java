package ru.itis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {
    String path = new File("").getAbsolutePath();
    Random random = new Random();

    public void generate(String fileName, int arraysAmount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path + "\\files\\" + fileName + ".txt"), false))) {
            int dose = 0;
            int t = 10000 / arraysAmount;
            for (int j = 0; j < arraysAmount; j++) {
                String text = "";
                for (int i = 0; i < 100 + dose; i++) {
                    text += String.valueOf(random.nextInt(Integer.MAX_VALUE)) + " ";
                }
                dose += t;
                writer.write(text);
                if (j == arraysAmount - 1) break;
                writer.newLine();
            }
            writer.flush();
            System.out.println("Файл сгенерирован");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
