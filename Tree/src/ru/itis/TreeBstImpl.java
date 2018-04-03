package ru.itis;

import java.util.Objects;

public class TreeBstImpl<T extends Comparable<T>> implements Tree<T> {
    class Node {
        private T value;
        private Node left;
        private Node right;

        Node(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }
    }

    private Node root;

    public TreeBstImpl() {
        this.root = null;
    }

    public void insert(T value) {
        this.root = insert(root, value);
    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
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

    //TODO:
    public boolean remove(T value) {
        return remove(root, value);
    }

    private boolean remove(Node node, T value) {
        if (node == null) return false;
        if (value.equals(node.right.value)) {
            Node currentNode = node.right.left;
            while (currentNode.right != null) {
                currentNode = currentNode.right;
                if (currentNode.right == null) {
                    currentNode.right = node.right.right.left;
                    break;
                }
            }
            node.right.right.left = node.right.left;
            node.right = node.right.right;
            return true;
        } else if (value.equals(node.left.value)) {
            Node currentNode = node.left.left;
            while (currentNode.right != null) {
                currentNode = currentNode.right;
                if (currentNode.right == null) {
                    currentNode.right = node.right.right.left;
                    break;
                }
            }
            node.right.right.left = node.right.left;
            node.right = node.right.right;
            return true;
        } else if (value.compareTo(node.value) <= 0) {
            return remove(node.left, value);
        } else {
            return remove(node.right, value);
        }
    }

    //TODO:
    public boolean contains(T value) {
       return contains(root, value);
    }

    private boolean contains(Node root, T value) {
        if (root == null) return false;
        if (value.equals(root.value)) {
            return true;
        } else if (value.compareTo(root.value) <= 0) {
            return contains(root.left, value);
        } else {
            return contains(root.right, value);
        }
    }

    //TODO:
    @Override
    public void printByLevels() {

    }

    //TODO
    @Override
    public boolean isBst() {
        return false;
    }


    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeBstImpl<?> treeBst = (TreeBstImpl<?>) o;
        return Objects.equals(root, treeBst.root);
    }

}
