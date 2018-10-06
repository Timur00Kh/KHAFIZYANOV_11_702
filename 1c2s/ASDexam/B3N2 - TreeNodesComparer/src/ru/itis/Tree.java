package ru.itis;

import java.util.ArrayList;

public class Tree<T extends Comparable<T>> {
    Node root;

    class Node {
        private T value;
        private Node left;
        private Node right;

        Node(T value) {
            this.value = value;
        }

    }

    public void insert(T value) {
        this.root = insert(root, value);
    }

    private Node insert(Node root, T value) {
        if (root == null) {
            root = new Node(value);
        } else if (value.compareTo(root.value) <= 0) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

    public void printNodes() {
        printNodes(root);
    }

    private int printNodes(Node current) {
        if (current == null) return 0;
        int l = printNodes(current.left);
        int r = printNodes(current.right);
        if(l != r) System.out.println(current.value + " " + l + " " + r);
        return l + r + 1;
    }

    ArrayList<ArrayList<T>> levels;
    public void printByLevels() {
        levels =  new ArrayList<>();
        levels(root, 0);
        for (int i = 0; i < levels.size(); i++) {
            String sLevel = "";
            for (int j = 0; j < levels.get(i).size(); j++) {
                sLevel += String.valueOf(levels.get(i).get(j)) + " ";
            }
            if (sLevel != "") System.out.println(sLevel);
        }
    }

    private void levels(Node node, int level) {
        if (node != null) {
            if (!levels.contains(level)) levels.add(new ArrayList<T>());
            levels.get(level).add(node.value);
            level++;
            levels(node.left, level);
            levels(node.right, level);
        }
    }
}
