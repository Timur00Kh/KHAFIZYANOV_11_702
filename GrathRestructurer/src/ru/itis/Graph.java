package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {

    Node root;
    int edgeAmount;
    int vertexAmount;
    int[] arr;

    class Node {
        int a;
        int b;
        Node next;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void readGraph(File file) {
        try {
            Scanner scanner = new Scanner(file);
            vertexAmount = scanner.nextInt();
            root = new Node(vertexAmount, scanner.nextInt());
            Node currentNode = root;
            edgeAmount++;
            while (scanner.hasNext()) {
                edgeAmount++;
                currentNode.next = new Node(scanner.nextInt(), scanner.nextInt());
                currentNode = currentNode.next;
                if (currentNode.a > vertexAmount) {
                    vertexAmount = currentNode.a;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void restructure() {
        arr = new int[vertexAmount+edgeAmount+1];
        Node currentNode = root;
        while (currentNode.next != null) {
            arr[currentNode.a]++;
            currentNode = currentNode.next;
        }
        int nextIndex = vertexAmount + 1;
        for (int i = 0; i < vertexAmount+1; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            } else {
                int tempInt = nextIndex;
                nextIndex += arr[i];
                arr[i] = tempInt;
            }
        }
        currentNode = root;
        while (currentNode != null) {
            int tempIndex = arr[currentNode.a];
            while (arr[tempIndex] != 0) {
                tempIndex++;
            }
            arr[tempIndex] = currentNode.b;
            currentNode = currentNode.next;
        }
    }

    public void print() {
        print(arr.length-1, vertexAmount);
    }

    private void print(int tempIndex, int i) {
        if (i < 0) return;
        String s = String.valueOf(i) + ":";
        if (arr[i] != -1) {
            while (tempIndex != arr[i] - 1) {
                s += " " + arr[tempIndex];
                tempIndex--;
            }
        } else {
            s += " ∞";
        }
        print(tempIndex,--i);
        System.out.println(s);
    }

    public void printOld() {
        int tempIndex = arr.length-1;
        for (int i = vertexAmount; i >= 0; i--) {
            String s = String.valueOf(i) + ":";
            if (arr[i] != -1) {
                while (tempIndex != arr[i] - 1) {
                    s += " " + arr[tempIndex];
                    tempIndex--;
                }
                System.out.println(s);
            } else {
                System.out.println(s + " ∞");
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "root=" + root +
                ", edgeAmount=" + edgeAmount +
                ", vertexAmount=" + vertexAmount +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
