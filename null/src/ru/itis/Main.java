package ru.itis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import sun.misc.IOUtils;


public class Main {

    public static void main(String[] args) {
        String p1 = "C:\\Users\\Timur Kh\\Desktop\\KHAFIZYANOV_11_702\\null\\files\\1.png";
        try {
            System.out.println(FileUtils.readFileToByteArray(new File(p1)).length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String p2 = "C:\\Users\\Timur Kh\\Desktop\\KHAFIZYANOV_11_702\\null\\files\\2.png";
        try {
            File file = ImageResizer.resize(p1, p2, 0.8);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            System.out.println(FileUtils.readFileToByteArray(new File(p2)).length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
