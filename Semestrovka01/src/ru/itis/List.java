package ru.itis;

public interface List extends Collection {
    Object get(int index);
    Object getValue(int index);
    void insert(int element);
    void decode(String path);
    int[] decode();
    void delete(int k);
    int maxNum();
}