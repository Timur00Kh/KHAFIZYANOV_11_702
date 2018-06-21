package ru.itis;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(1);
        tree.insert(1);
        tree.insert(1);

        tree.printByLevels();
        System.out.println("========");
        tree.printNodes();
    }
}
