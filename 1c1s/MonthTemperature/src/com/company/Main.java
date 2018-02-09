package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	    File input = new File("C:\\Users\\Timur Kh\\Desktop\\KHAFIZYANOV_11_702\\MonthTemperature\\src\\com\\company\\input.txt");
        Scanner scanner = new Scanner(input);

        double monthTemp[] = new double[13];
        int daysCount[] = new int[13];

        while(scanner.hasNext()){
            String date = scanner.next();
            String temp = scanner.next();
            int month = ((int) date.charAt(3) - '0') * 10 + ((int) date.charAt(4) - '0');
            monthTemp[month] += Double.parseDouble(temp);
            daysCount[month]++;
        }

        double yearAVG = 0;

        for (int i = 1; i <= 12; i++) {
            monthTemp[i] = monthTemp[i] / daysCount[i];
            yearAVG += monthTemp[i];
        }

        yearAVG = yearAVG / 12;
        double deltaMonthTemp = Math.abs(monthTemp[1] - yearAVG);
        int minMonth = 0;

        for (int i = 1; i <= 12; i++) {
            if (Math.abs(monthTemp[i] - yearAVG) < deltaMonthTemp) {
                deltaMonthTemp = Math.abs(monthTemp[i] - yearAVG);
                minMonth = i;
            }
        }

        System.out.println(minMonth);
    }
}