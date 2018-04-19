package ru.itis;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap<K,V> {
    private final static int SIZE = 10;
    private MyLinkedList<K, V>[] list = new MyLinkedList[SIZE];

    MyHashMap() {
        for (int i = 0; i < SIZE; i++){
            list[i] = new MyLinkedList<>();
        }
    }


    public V get(K key) {
        int t = Objects.hash(key) % 10;
        return list[t].get(key);
    }


    public void set(K key, V val) {
        list[Objects.hash(key) % 10].setOrAdd(key, val);
    }

//    public int[][] getAs2Array() {
//        MyLinkedList<K, V> linkedList = new MyLinkedList();
//
//        for(int i = 0; i < SIZE; i++) {
//            linkedList.concat(list[i]);
//        }
//
//    }
}

//    private class Elem {
//        K key;
//        V val;
//
//        Elem(K key, V value) {
//            this.key = key;
//            this.val = value;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Elem elem = (Elem) o;
//            return Objects.equals(key, elem.key) &&
//                    Objects.equals(val, elem.val);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(key) % 10;
//        }
//    }

