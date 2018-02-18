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
		for (int i=n-1; i>=0; i--) {
			for (int j=0; j<i; j++) {
				if (a[j]>a[j+1]) {
					c = a[j+1];
					a[j+1] = a[j];
					a[j] = c;
				}
			}
		}
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
        



		