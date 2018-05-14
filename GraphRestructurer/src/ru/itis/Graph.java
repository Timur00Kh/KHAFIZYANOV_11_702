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

    Graph() {
        edgeAmount = 0;
        vertexAmount = 0;
    }

    class Node {
        int a;
        int b;
        Node next;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
/*
    По красоте наверн надо преренести readGraph() в конструктор Graph()
    и из этого конструктора вызвать restructure().
    Все методы сделать приватными, кроме print() и Graph().
*/
    public void readGraph(File file) {
        try {
            Scanner scanner = new Scanner(file);
            root = new Node(scanner.nextInt(), scanner.nextInt());
            Node currentNode = root;
            edgeAmount++;
            while (scanner.hasNext()) {
                if (currentNode.a > vertexAmount) vertexAmount = currentNode.a;
                if (currentNode.b > vertexAmount) vertexAmount = currentNode.b;
                edgeAmount++;
                currentNode.next = new Node(scanner.nextInt(), scanner.nextInt());
                currentNode = currentNode.next;
            }
            if (currentNode.a > vertexAmount) vertexAmount = currentNode.a;
            if (currentNode.b > vertexAmount) vertexAmount = currentNode.b;
            vertexAmount++;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void restructure() {
        if(root == null) System.err.println("Did you read a graph??");
        arr = new int[vertexAmount + edgeAmount];
        Node currentNode = root;
        while (currentNode != null) {
            arr[currentNode.a]++;
            currentNode = currentNode.next;
        }
        int nextIndex = vertexAmount;
        for (int i = 0; i < vertexAmount; i++) {
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
            //можно избавиться от этого while изменяя индексы в arr
            while (arr[tempIndex] != 0) {
                tempIndex++;
            }
            arr[tempIndex] = currentNode.b;
            currentNode = currentNode.next;
        }
    }

    public void print() {
        if(root == null) System.err.println("Did you read a graph??");
        if(arr == null) System.err.println("Did you restructure the graph??");
        for (int i = 0; i < vertexAmount; i++){
            System.out.print(i + ": ");
            if (arr[i] != -1){
                int begin = arr[i];
                int end = i + 1;
                for (; arr[end] == -1 && (end < vertexAmount); end++);
                end = (end == vertexAmount) ? arr.length : arr[end];
                for (int j = begin; j < end; j++){
                    System.out.print(arr[j] + " ");
                }
            } else {
                System.out.print("∞");
            }
            System.out.println();
        }
    }

    public void printOld() {
        if(root == null) System.err.println("Did you read a graph??");
        if(arr == null) System.err.println("Did you restructure the graph??");
        printOld(arr.length-1, vertexAmount-1);
    }

    private void printOld(int tempIndex, int i) {
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
        printOld(tempIndex,--i);
        System.out.println(s);
    }

    public void printOldOld() {
        int tempIndex = arr.length-1;
        for (int i = vertexAmount-1; i >= 0; i--) {
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
