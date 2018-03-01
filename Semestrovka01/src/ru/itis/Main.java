package ru.itis;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,2,4,5};
        MyLinkedList2 list1 = new MyLinkedList2(arr);
        list1.delete(5);

        MyLinkedList2 list = new MyLinkedList2();
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        list.insert(11);


        System.out.println(list1.maxNum());

        int[] arr2 = list.decode();

        list.decode("C:\\Users\\Timur Kh\\Desktop\\KHAFIZYANOV_11_702\\Semestrovka01\\src\\input.txt");

        MyLinkedList2 mergedList = list.merge(list1);

        MyLinkedList2[] dividedLists = mergedList.divide();

        int t = 0;
    }
}
