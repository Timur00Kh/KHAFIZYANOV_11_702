package ru.itis;

import java.util.LinkedList;

public class MyLinkedList<K, V> {

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    private class Node {
        K key;
        V val;
        Node next;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void add(K key, V val) {
        Node newNode = new Node(key, val);
        if (head == null) {
            head  = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void setOrAdd(K key, V val) {
//        Node newNode = new Node(key, val);
        Node node = this.head;
        boolean flag = false;
        while (node != null) {
            if (key.equals(node.key)) {
                node.val = val;
                flag = true;
                break;
            }
            node = node.next;
        }
        if (!flag) {
            add(key, val);
            size++;
        }
    }

    public V get(K key) {
        Node node = this.head;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.val;
            }
            node = node.next;
        }
        return null;
    }

//    public void concat(MyLinkedList<K,V> list) {
//        Node node = list.head;
//        while (node != null) {
//            this.tail.next = node;
//            this.tail = node;
//            node = node.next;
//        }
//    }

//    public int[][] getAs2Array() {
//        Node node = this.head;
//        int[][] array = new int[size][2];
//        for (int i = 0; i < size; i++) {
//            array[i][0] = node.key;
//        }
//    }
}
