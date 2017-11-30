package ru.itis;

import java.io.FileInputStream;

class MyScanner {
    private FileInputStream input;

    public MyScanner(String name) {
        try {
            input = new FileInputStream(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String nextLine() throws Exception{
        FileInputStream input = new FileInputStream("src/input.txt");
        byte bytes[] = new byte[100];
        int length = input.read(bytes);
        String s = "";
        for (byte current : bytes) {
            s += ((char)current);
        }
    }

    public int nextInt() throws Exception{

    }
}