package ru.itis;

import java.util.ArrayList;

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
        if (root == null) return false;
        if (root.value.equals(value)) {
            if (root.right == null && root.left == null){
                this.root = null;
                return true;
            }
            if (root.left != null) {
                Node currentNode = root.left;
                while (currentNode != null && currentNode.right != null) {
                    currentNode = currentNode.right;
                    if (currentNode.right == null) {
                        currentNode.right = root.right.left;
                        break;
                    }
                }
                root.right.left = root.left;
                return true;
            } else {
                this.root = root.right;
                return true;
            }
        } else if (value.compareTo(root.value) <= 0) {
            return remove(root, root.left, value);
        } else {
            return remove(root, root.right, value);
        }
    }

    private boolean remove(Node parent, Node node, T value) {
        if (node == null) return false;

        if(node.value.equals(value)) {
            if (root.right == null && root.left == null) {
                return removeChild(parent, node);
            }
            if (node.left != null) {
                if (node.right != null) {
                    Node currentNode = node.left;
                    while (currentNode != null && currentNode.right != null) {
                        currentNode = currentNode.right;
                        if (currentNode.right == null) {
                            currentNode.right = node.right.left;
                            break;
                        }
                    }
                    node.right.left = node.left;
                } else {
                    if (parent.right.value.equals(node.value)) {
                        parent.right = node.left;
                    } else {
                        parent.left = node.left;
                    }
                }
            } else {
                if (parent.right.value.equals(node.value)) {
                    parent.right = node.right;
                } else {
                    parent.left = node.right;
                }
            }
            return true;
        } else if (value.compareTo(node.value) <= 0) {
            return remove(node, node.left, value);
        } else {
            return remove(node, node.right, value);
        }
    }

    private boolean removeChild(Node parent, Node node){
        if (parent.right.value.equals(node.value)) {
            parent.right = null;
        } else if(parent.left.value.equals(node.value)) {
            parent.left = null;
        } else {
            return false;
        }
        return true;
    }

    public boolean removeOld(T value) {
        return removeOld(root, value);
    }

    //можно было создать метод, кторотый получает и предка и потомка, но я пошел более сложным путем.
    //потом перепишу
    //UPD: работает не во всех случаях
    //нужно срочно переписать
    private boolean removeOld(Node node, T value) {
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
            return removeOld(node.left, value);
        } else {
            return removeOld(node.right, value);
        }
    }

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

    ArrayList<ArrayList<T>> levels;
    @Override
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

    @Override
    public boolean isBst() {
        return isBst(root);
    }


    //maybe correct
    private boolean isBst(Node node) {
        if (node.left == null) return true;
        if (node.value.compareTo(node.left.value) >= 0) {
            if (node.right == null) return true;
            if (isBst(node.left) && node.value.compareTo(node.right.value) <= 0) {
                return isBst(node.right);
            } else return false;
        } else return false;

    }



    public boolean equals(TreeBstImpl t) {
        return equals(root, t.root);

    }

    private boolean equals(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1.value.equals(tree2.value)) {
            if (equals(tree1.left, tree2.left))
            return equals(tree1.right, tree2.right);
            else return false;
        } else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeBstImpl<T> treeBst = (TreeBstImpl<T>) o;
        return equals(root, treeBst.root);
    }
}
