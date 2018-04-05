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
            if(node.right.left != null) {
                Node currentNode = node.right.left;
                while (currentNode.right != null) {
                    currentNode = currentNode.right;
                    if (currentNode.right == null) {
                        currentNode.right = node.right.right.left;
                        break;
                    }
                }
            }
            node.right.right.left = node.right.left;
            node.right = node.right.right;
            return true;
        } else if (value.equals(node.left.value)) {
            if(node.left.left != null) {
                Node currentNode = node.left.left;
                while (currentNode.right != null) {
                    currentNode = currentNode.right;
                    if (currentNode.right == null) {
                        currentNode.right = node.left.right.left;
                        break;
                    }
                }
            }
            node.left.right.left = node.left.left;
            node.left = node.left.right;
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
        return isBst(root);
    }

    private boolean isBst(Node node) {
        if (node.left == null) {

        }
        if (node.left.value.compareTo(node.value) <= 0) {
            if (node.left.left == null) return true;
            else return isBst(node.left);
            if (node.right.value.compareTo(node.value) > 0) {
                return isBst(node.right);
            } else return false;
        } else return false;
    }



//    public boolean equals(TreeBstImpl t) {
//        return equals(root, t.root);
//    }

//    private boolean equals(Node tree1, Node tree2) {
//        if (tree1 != null && tree2 != null) {
//            if (tree1.value.equals(tree2.value)) {
//                if(equals(tree1.left, tree2.left)) return true;
//                else return false;
//            } else return false;
//            if (tree1.value.equals(tree2.value)) {
//                equals(tree1.right, tree2.right);
//            }
//            else return false;
//        }
//        return true;
//    }

}
