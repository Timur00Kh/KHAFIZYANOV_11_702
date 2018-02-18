package ru.itis;

public class Main {

    public static void main(String[] args) {
        LinkedList listA = new LinkedList();
        LinkedList listB = new LinkedList();
        listA.addToBegin(1);
        listA.add(3);
        listA.add(6);
        listA.add(6);
        listA.add(6);
        listA.add(6);
        listA.add(6);
        listB.add(2);
        listB.add(2);
        listB.add(2);
        listB.add(2);
        listB.add(2);
        listB.add(2);
        listB.add(4);
        listB.add(5);
        listB.add(5);
        listB.add(5);
        listB.add(5);
        listB.add(5);

        LinkedList l = LinkedList.merge(listA, listB);
        l.print();
        System.out.println("length: " + l.getLength());

        System.out.println("===================");

        listA = new LinkedList();
        listB = new LinkedList();
        listA.add(6);
        listB.addToBegin(2);
        l = LinkedList.merge(listA, listB);
        l.print();

        System.out.println("===================");

        LinkedList list = new LinkedList();
        list.add(4);
        list.add(78);
        list.add(4);
        list.add(2);
        list.add(9);
        list.add(5);
        list.add(90);
        list.add(3);
        list.add(1);
        list.add(0);
        list.add(44);

        list = list.sort();
        list.print();
        System.out.println("length: " + list.getLength());


//        Object obj = list.get(5);
//        System.out.println(list.contains(obj));
//        System.out.println(list.getValue(5));
//        list.remove(obj);
//        list.print();
        int i = 0;

    }
}