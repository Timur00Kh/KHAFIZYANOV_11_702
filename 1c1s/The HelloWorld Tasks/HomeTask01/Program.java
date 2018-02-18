import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int p = 1; 
		int s = 0;
		int n = 0;
		int a1 = 0;
		int a = scanner.nextInt();
		while (a != -1) {
			a1 = a;	
			if (a % 10 == 7) {
				s += a;
				}
			while (a != 0) {
				n += a % 10;
				a = a / 10;
				}
			if (n % 2 == 0) {
				p *= a1;
				}
			n = 0;
			a = scanner.nextInt();
			}
		System.out.println(p);
		System.out.println(s);
 	}
}
	
		