import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		n = scanner.nextInt();
		int max = n;
		int min = n;
		while (n != -1) {
			n = scanner.nextInt();
			if (n != -1) {
				if (n>max) {
					max = n;
				}
				if (n<min) {
					min = n;
				}
			}
		}
		max = max - min;
		System.out.println(max);
	}
}