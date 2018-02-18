import java.util.Scanner;

class Program {
	public static void bubbleSort(int a[]) {
		int c = 0;
		for (int i=a.length-1; i>=0; i--) {
			for (int j=0; j<i; j++) {
				if (a[j]>a[j+1]) {
					c = a[j+1];
					a[j+1] = a[j];
					a[j] = c;
				}
			}
		}
	}
	public static void printArray(int a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); 
		int x[] = new int[n];
		for (int i=0; i<x.length; i++) {
			x[i] = scanner.nextInt();
		}
		bubbleSort(x);
		printArray(x);
	}
}