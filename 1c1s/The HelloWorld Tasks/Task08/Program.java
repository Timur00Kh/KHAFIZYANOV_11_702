import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); 
		int a[] = new int[n];
		int c = 0;
		for (int i=0; i<a.length; i++) {
			a[i] = scanner.nextInt();
		}
		for (int i=0; i<(n/2); i++) {
			c = a[i];
			a[i] = a[n-1-i];
			a[n-1-i] = c;
		}
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
}