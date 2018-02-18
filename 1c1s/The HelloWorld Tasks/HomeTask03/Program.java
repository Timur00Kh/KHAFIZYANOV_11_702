import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		//n = scanner.nextInt();
		int x[] = new int[99];	
		for (int i=0; i<x.length-1; i++) {
        	int a = scanner.nextInt();
        	x[a-1] = a;
        }
        
        for (int i=0; i<x.length; i++) {
			//System.out.println(x[i]);
			if (x[i] == 0) {
				System.out.println(i+1);
				//break;
			}
		}
	}
}