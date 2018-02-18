import java.util.Scanner;

class Program {
	public static double f(double x) {
		return Math.sin(1 / x);
		
	}	
	public static double integrate(double a, double b, double h, int n) {
		double sum = 0;
		double x = a;
		for (int i = 0; i<n; i++){
			x += h;
			sum += f(x);
		}
		sum *= h;
		return sum;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a = scanner.nextInt();
		double b = scanner.nextInt();
		int n = scanner.nextInt();
		double h = ((b-a)/n);
		double integral = integrate(a, b, h, n);
		System.out.println(integral);
	}

}
