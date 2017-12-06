package com.company;

public class Main {

    public static void main(String[] args) {
        int[] a = {2, 4, 8, 11, 11, 13, 16, 19, 20};
        int x = find(a, 0, 8, 19);
        System.out.println(x);
    }

    static int find(int a[], int lower, int higher, int x) {
        int mid = lower + (higher - lower)/2;
        if (a[mid] > x) {
            return find(a, lower, mid, x);
        } else if (a[mid] < x) {
            return find(a, mid, higher, x);
        } else if (a[mid] == x) {
            return mid;
        } else {
            return -1;
        }
    }
    
}
