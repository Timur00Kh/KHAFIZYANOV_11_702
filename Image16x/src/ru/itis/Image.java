package ru.itis;

import java.util.ArrayList;

public class Image {
    ArrayList<Pixel> pixels = new ArrayList();

    public void setPixel(int a, int b, int c) {
        pixels.add(new Pixel(a, b, c));
    }

    public Image getRComponent() {
        Image returnImage = new Image();
        for (int i = 0; i < this.pixels.size(); i++) {
            returnImage.setPixel(this.pixels.get(i).r, 0, 0);
        }
        return returnImage;
    }

    public void print() {
        System.out.println(this.pixels.size());
        for (int i = 0; i < this.pixels.size(); i++) {
            this.pixels.get(i).ptint();
        }
    }
}
