import java.util.Scanner;

public class SecondClass {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		long limit = in.nextLong();
		
		in.close();
		long sum = 0;
		long f1 = 1;
		long f2 = 2;
		long aux = 0;
		
		System.out.println(limit); 

		while ((aux) <= limit){
			System.out.println(f2); 
			if (f2 % 2 == 0){
				sum = sum + f2;
			}
			aux = f2+f1;
			f1 = f2;
			f2 = aux;
		}
	System.out.print("Sum of Fibonnaci even-valued terms : ");
	System.out.println(sum); 
	}
}