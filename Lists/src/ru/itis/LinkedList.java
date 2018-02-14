package ru.itis;


/**
 * 13.02.2018
 * LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LinkedList implements List {

    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }
    // ссылка на первый элемент списка
    private Node head;
    // ссылка на последний элемент списка
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public Object get(int index) {
//        index--;
        Node node = this.head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    public Object getValue(int index) {
//        index--;
        Node node = this.head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node.value;
    }

    @Override
    public void addToBegin(Object object) {
        Node newNode = new Node(object);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public void remove(Object element) {
        Node node = this.head;
        Node nodeP = this.head;

        if (element == node) {
            this.head = node.next;
        }

        while (node != this.tail) {
            if (node == element) {
                nodeP.next = node.next;
                return;
            }
            nodeP = node;
            node = node.next;

        }
        if (node == this.tail && element == node) {
            nodeP.next = null;
            this.tail = nodeP;
            return;
        }
        System.err.println("Нет такого элемента");
    }


    @Override
    public boolean contains(Object element) {
        Node node = this.head;
        while (node != this.tail) {
            if (node == element) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}