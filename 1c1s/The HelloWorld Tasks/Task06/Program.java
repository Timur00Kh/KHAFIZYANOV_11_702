import java.util.Scanner; 
class Program { 

public static void main (String[] args) { 
	Scanner scanner = new Scanner(System.in); 
	int N = scanner.nextInt(), min = 9999, s; int mini = 0; 
	int a[] = new int[N]; 
	for (int i= 0; i < N; i++) { 
		a[i] = scanner.nextInt(); 
	} 
	for (int j = 0; j < N; j++) { 
		for (int i= j; i < N; i++) { 
			if (a[i] < min) { 
			min = a[i]; 
			mini = i; 
			} 
		} 
		
		min = 9999; 
		s = a[j]; 
		a[j] = a[mini]; 
		a[mini] = s; 

	} 
	

	for (int i=0; i < N; i++ ) { 
		System.out.println(a[i] + " ") ; 
	} 
} 
}