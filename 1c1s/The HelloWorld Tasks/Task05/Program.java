import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[] = new int[n];
		int k = 0;
		int max = 0;
		int min = 0;
		for (int i=0; i<a.length; i++) {
			a[i] = scanner.nextInt();
		}
		k = a[0];
		for (int i=1; i<a.length; i++) {
			if (a[i]>k){
				k = a[i];
				max = i;
			}
		}
		k = a[0];
		for (int i=1; i<a.length; i++) {
			if (a[i]<k){
				k = a[i];
				min = i;
			}
		}
		a[max] = a[max] + a[min];
		a[min] = a[max] - a[min];
		a[max] = a[max] - a[min];
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
}
