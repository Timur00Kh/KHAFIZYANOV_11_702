package ru.itis;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Figure {
    int figure;
    int matches[] = new int[10];
    int steps[] = new int[10]; //кол-во шагов превращ числа figure в i-тое число в пределах одной цифры
    int steps2[] = new int[10]; //кол-во переносов спичек в пределах одной цифры


    int numberWight[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    NumStepCalculator numStepCalculator = new NumStepCalculator();

    Figure(int n) throws FileNotFoundException {
        this.figure = n;

        for (int i = 0; i < 10; i++) {
            matches[i] = numberWight[n] - numberWight[i];
        }
        for (int i = 0; i < 10; i++) {
            steps[i] = numStepCalculator.calcSteps(n, i);
            steps2[i] = Math.abs(Math.abs(matches[i]) - Math.abs(steps[i]));
        }

    }

    public void print() {
        for (int i =0; i < 10; i++) {
            System.out.println(matches[i] + " " + steps[i] + " " + steps2[i]);
        }
    }

    public void print(int i) {
        System.out.println(matches[i] + " " + steps[i] + " " + steps2[i]);
    }


}
