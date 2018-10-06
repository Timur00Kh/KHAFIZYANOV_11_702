package ru.itis;

import java.io.*;

public class MyLinkedList2 implements List {

    private static class Node {
        int value; // mb int??
        Node next;
        Node previous;

        Node(int value) {
            this.value = value;
        }
    }
    // ссылка на первый элемент списка
    private Node head;
    // ссылка на последний элемент списка
    private Node tail;
    //размер
    private int length;
    //

    public MyLinkedList2(){}

    public MyLinkedList2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            this.insert(arr[i]);
        }
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object getValue(int index) {
        return null;
    }

    @Override
    public void decode(String path) {
        FileOutputStream file = null;
        DataOutputStream dataOutputStream = null;
        try {
            File fileDir = new File(path);
            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileDir), "UTF8"));

            Node node = this.head;
            while (node != null) {
                out.append(String.valueOf(node.value)).append(' ');
                node = node.next;
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int[] decode() {
        int[] arr = new int[this.length];
        int i = 0;
        Node node = this.head;
        while (node != null) {
            arr[i] = node.value;
            i++;
            node = node.next;
        }

        return arr;
    }

    @Override
    public void delete(int k) {
        Node node = this.head;

        while (node != null) {
            if (node.value == k) {
                if (node.previous != null) node.previous.next = node.next;
                else this.head = node.next;
                if (node.next != null) node.next.previous = node.previous;
                else this.tail = node.previous;
                this.length -= 1;
                return; //т.к. удалить нужно только один элемент.
            }
            node = node.next;
        }
    }

    @Override
    public int maxNum() {
        int max = Integer.MIN_VALUE;
        Node node = this.head;

        while (node != null) {
            if (node.value > max) {
                max = node.value;
            }
            node = node.next;
        }

        node = this.head;
        int[] nums = new int[max + 1];
        while (node != null) {
            nums[node.value]++;
            node = node.next;
        }

        int maxOccurence = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxOccurence) maxOccurence = nums[i];
        }

        return  maxOccurence; // сложность = 3n, но пойдет
    }

    @Override
    public void insert(int element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail.next.previous = tail;
            tail = newNode;
        }
        this.length += 1;
    }

    public MyLinkedList2 merge(MyLinkedList2 sortedB) {
        MyLinkedList2 linkedList = new MyLinkedList2();
        Node nodeA = this.head;
        Node nodeB = sortedB.head;
        int index = this.getLength() + sortedB.getLength();
        while (nodeA != null && nodeB != null) {
            if ((Integer)nodeA.value < (Integer)nodeB.value) {
                linkedList.insert(nodeA.value);
                nodeA = nodeA.next;
            } else {
                linkedList.insert(nodeB.value);
                nodeB = nodeB.next;
            }
            index--;
        }

        while (index > 0) {
            if (nodeA == null) {
                linkedList.insert(nodeB.value);
                nodeB = nodeB.next;
            } else {
                linkedList.insert(nodeA.value);
                nodeA = nodeA.next;
            }
            index--;
        }

        return linkedList;
    }

    public MyLinkedList2[] divide() {
        MyLinkedList2 list = new MyLinkedList2();
        MyLinkedList2 listDiv3 = new MyLinkedList2();
        MyLinkedList2[] lists = {listDiv3, list};

        Node node = this.head;

        while (node != null) {
            if (node.value % 3 == 0) {
                listDiv3.insert(node.value);
            } else {
                list.insert(node.value);
            }
            node = node.next;
        }

        return lists;
    }

    MyLinkedList2 newList() {
        int[] arr = this.decode();
        MyLinkedList2 list = new MyLinkedList2();
        for (int i = 0; i < arr.length; i++) {
            list.insert(arr[i] * arr[arr.length - i]);
        }

        return  list;
    }

    @Override
    public void remove(Object element) {

    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    public int getLength() {
        return length;
    }
}
