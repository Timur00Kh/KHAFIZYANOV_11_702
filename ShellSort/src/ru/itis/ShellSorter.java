package ru.itis;

public class ShellSorter {
    private static int lastNumberOfIterations = 0;

    public static int[] sort(int[] array) {
        int inner, outer;
        int temp;
        lastNumberOfIterations = 0;

        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;//здесь регулируется шаг
        }
        while (h > 0) {
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                    lastNumberOfIterations++;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3; //здесь регулируется шаг
        }
        return array;
    }

    public static int getLastNumberOfIterations() {
        return lastNumberOfIterations;
    }
}
