package ru.itis;

public class Main {

    public static void main(String[] args) {
        List list = new LinkedList();
        list.addToBegin(123);
        list.addToBegin(124);
        list.addToBegin(125);
        list.addToBegin(126);
        list.add(505);
        list.add(404);


        Object obj = list.get(5);
        System.out.println(list.contains(obj));
        System.out.println(list.getValue(5));
        list.remove(obj);
        int i = 0;

    }
}