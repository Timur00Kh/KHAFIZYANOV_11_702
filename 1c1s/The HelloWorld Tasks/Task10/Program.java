import java.util.Scanner;

class Program {
	public static boolean isPrime(int number) {
		int k = 0;
		if (number == 2 && number == 3){
			return true;
		}
		for (int i = 2; i * i <= number; i++){
			if (number % i == 0) {
				k++;
               //цикл с double чет не пошел, поэтому счетчик
			}
		}

		if (k >= 1) {
			return false;
		} else return true;
	}	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.println(isPrime(x));
	}
}
