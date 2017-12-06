package com.company;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
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

=======
        int[] a = {2, 4, 11};

        System.out.println(find(a, 0, 2, 11));
    }

    public static int find (int[] a,int lower, int higher, int x){
        int mid = lower + (higher - lower)/2;
        if (a[mid] == x){return mid;}
        if (higher - lower == 0) { return -1; }
        System.out.println(a[mid] + ' ' + lower + ' ' + higher + ' ' + x);
        if (a[mid] > x){
            return find(a, lower, mid, x);
        } else {
            return find(a, mid, higher, x);
        }

    }
>>>>>>> 9f129043b259f32a92b589b35ded043c66bc79a1
}
