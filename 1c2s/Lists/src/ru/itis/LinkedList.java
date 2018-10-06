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
    //размер
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
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
        //может давать ошибку при зацикленных списках
        //хотя зацикленный список - уже ошибка

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
        this.length += 1;
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.length += 1;
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
                length--;
                return;
            }
            nodeP = node;
            node = node.next;

        }
        if (node == this.tail && element == node) {
            nodeP.next = null;
            this.tail = nodeP;
            length--;
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

    public static LinkedList merge(LinkedList sortedA, LinkedList sortedB) {
        LinkedList linkedList = new LinkedList();
        Node nodeA = sortedA.head;
        Node nodeB = sortedB.head;
        int index = sortedA.getLength() + sortedB.getLength();
        while (nodeA != null && nodeB != null) {
            if ((Integer)nodeA.value < (Integer)nodeB.value) {
                linkedList.add(nodeA.value);
                nodeA = nodeA.next;
            } else {
                linkedList.add(nodeB.value);
                nodeB = nodeB.next;
            }
            index--;
        }

        while (index > 0) {
            if (nodeA == null) {
                linkedList.add(nodeB.value);
                nodeB = nodeB.next;
            } else {
                linkedList.add(nodeA.value);
                nodeA = nodeA.next;
            }
            index--;
        }

        return linkedList;
    }

    public void print() {
        Node node = this.head;
        while (node != this.tail) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value);
    }

    public int getLength() {
        return length;
    }

    public LinkedList sort() {
        int k = 0;
        LinkedList[] lists = new LinkedList[31];
//        for (LinkedList list : lists) list = new LinkedList(); //почему не работает!?
        for (int i = 0; i < lists.length; i++){
            lists[i] = new LinkedList();
        }
        Node currentNode = this.head.next.next;
        int index = 1;
        lists[0].add(this.head.value);
        lists[1].add(this.head.next.value);
        while (currentNode != null || lists[1].length > 0) {
            k++;
            if (lists[index].length == lists[index-1].length || currentNode == null) {
                lists[index-1] = merge(lists[index], lists[index-1]);
                lists[index] = new LinkedList();
                if (index > 1) {
                    index--;
                    continue;
                }
            } else index++;

            //как-то костыльно выглядит, но работает
            if (currentNode == null) continue;

            lists[index].add(currentNode.value);
            currentNode = currentNode.next;
        }
//        this = lists[0];
        System.out.println("Кол-во итераций сортировки: " + k);
        return lists[0];
    }
}