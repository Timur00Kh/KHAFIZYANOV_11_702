import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); 
		int a[] = new int[n];
		int min = 0;
		int c = 0;
		for (int i=0; i<a.length; i++) {
			a[i] = scanner.nextInt();
		}
		for (int i=0; i<a.length; i++) {
			int d = a[i];
			for (int j=i+1; j<a.length; j++) {
				if (a[j]<d) {
					d = a[j];
					min = j;
				}
			}
			c = a[min];
			a[min] = a[i];
			a[i] = c;
		}
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
