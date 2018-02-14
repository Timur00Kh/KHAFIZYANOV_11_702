package ru.itis;

/**
 * 13.02.2018
 * List
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface List extends Collection {
    Object get(int index);
    Object getValue(int index);
    void addToBegin(Object object);
}