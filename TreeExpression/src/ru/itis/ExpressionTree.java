package ru.itis;

import java.util.ArrayList;

public class ExpressionTree {
    Node root;
    char[] chars;

    class  Node {
        Node right;
        Node left;
        Node parent;
        char value;

        Node(char s) {
            value = s;
        }

        Node(){};
    }

    private void insertLeftChild(Node parent, Node child) {
        parent.left = child;
        child.parent = parent;
    }

    private void insertRightChild(Node parent, Node child) {
        parent.right = child;
        child.parent = parent;
    }

    public void insert(String s) {
        chars = s.toCharArray();
        root = new Node();
        try {
            insert(0, root);
        } catch (NullPointerException e){
            System.err.println("Structure of expression is not correct");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void insert(int i, Node currentNode) throws IllegalArgumentException {
        if (i >= chars.length) return;
        if (chars[i] == '(') {
            insertLeftChild(currentNode, new Node());/*currentNode.left = new Node(chars[i]);*/
            insert(++i, currentNode.left);
        } else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
            currentNode.value = chars[i];
            insertRightChild(currentNode, new Node());/*currentNode.right = new Node()*/
            insert(++i, currentNode.right);
        } else if (chars[i] >= '0' && chars[i] <= '9') {
            currentNode.value = chars[i];
            insert(++i, currentNode.parent);
        } else if (chars[i] == ')') {
            if (chars.length-i <= 1) return;
            insert(++i, currentNode.parent);
        } else {
            throw new IllegalArgumentException("\"" + chars[i] + "\" " + "is illegal character");
        }
    }

    private ArrayList<ArrayList<Character>> levels;
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
            if (!levels.contains(level)) levels.add(new ArrayList<Character>());
            levels.get(level).add(node.value);
            level++;
            levels(node.left, level);
            levels(node.right, level);
        }
    }
}
