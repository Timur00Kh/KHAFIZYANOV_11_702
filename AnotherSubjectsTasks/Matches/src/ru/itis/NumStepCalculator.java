package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumStepCalculator {

    ArrayList<int[]> numPatterns = new ArrayList();
    File input = new File("src\\NumPatterns.txt");
    Scanner scanner = new Scanner(input);

    NumStepCalculator() throws FileNotFoundException {
        for (int i = 0; i < 10; i++) {
            int tempPattern[] = new int[7];
            for (int j = 0; j < 7; j++) {
                tempPattern[j] = scanner.nextInt();
            }
            numPatterns.add(tempPattern);
        }
    }

    public int calcSteps(int x, int y) {
        int tempCount1 = 0;
        int tempCount2 = 0;
        for (int j = 0; j < 7; j++) {
            if (numPatterns.get(x)[j] < numPatterns.get(y)[j]) tempCount1++;
            if (numPatterns.get(x)[j] > numPatterns.get(y)[j]) tempCount2--;
        }
//        System.out.println(tempCount1 + " " + tempCount2);
        return max(tempCount1, tempCount2);
//        return Math.abs(tempCount1 - tempCount2);
//        return tempCount1;
    }

    public int max(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x > y) return x;
        return y;
    }
}
