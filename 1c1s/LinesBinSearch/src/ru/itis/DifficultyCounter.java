package ru.itis;

public class DifficultyCounter {
    public static int binSearchCallCount = 0;
    public static int sortCallCount = 0;

    public static int getBinSearchCallCount() {
        return binSearchCallCount;
    }

    public static int getSortCallCount() {
        return sortCallCount;
    }
}
