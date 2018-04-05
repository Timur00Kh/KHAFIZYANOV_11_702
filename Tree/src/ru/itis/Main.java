package ru.itis;

public class Main {

    public static void main(String[] args) {
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        int array3[] = {5, 2, 8, 2, 5, 6, 10, 1, 3, 6, 7, 8};

        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        TreeBstImpl<Integer> tree2 = new TreeBstImpl<>();
        TreeBstImpl<Integer> tree3 = new TreeBstImpl<>();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            tree2.insert(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            tree3.insert(array3[i]);
        }

        tree.print();

        System.out.println(tree.contains(0));
        System.out.println(tree.equals(tree2));
        System.out.println(tree.equals(tree3));

        tree.remove(6);
        tree.print();
        System.out.println(tree.isBst());



    }
}