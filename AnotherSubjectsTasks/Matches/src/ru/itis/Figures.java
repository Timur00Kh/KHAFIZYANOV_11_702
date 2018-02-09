package ru.itis;

import java.util.ArrayList;

public class Figures {
    ArrayList<Figure> figures = new ArrayList<>();

    public Figures(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public Figures(Figure f[]) {
        for (int i = 0; i < f.length; i++) {
            this.figures.add(f[i]);
        }
    }

    public Figures() {
        this.figures = new ArrayList<>();
    }

    public void add(Figure f) {
        this.figures.add(f);
    }

    public int calcSteps(int a[]) {
//        int steps = 0;
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < this.figures.size() - 1; i++) {
            if (figures.get(i).matches[a[i]] < 0) {
                neg += figures.get(i).matches[a[i]];
            } else pos += figures.get(i).matches[a[i]];
        }

        return max(pos, neg);
    }

    public int max(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x > y) return x;
        return y;
    }

    public int getSize() {
        return this.figures.size();
    }

    public Figure get(int i) {
        return this.figures.get(i);
    }

}
