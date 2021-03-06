package ru.itis;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        LinkedList<> list = new LinkedList<>();
        list.add(185);
        list.add(170);
        list.add(178);
        list.add(167);
        list.add(183);
        list.add(171);
        list.add(179);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Object obj = list.get(2);
        list.contains(obj);

        System.out.println("С итератором: ");
        Iterator<Integer>  iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("С foreach");
        for (int value : list) {
            System.out.println(value);
        }
    }
}