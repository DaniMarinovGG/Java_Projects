// this program will evaluate the expression (x+y)^n
// Ex: n=2 -> (x+y)^2 = x^2+2xy+y^2
// Ex: n=5 -> (x+y)^3 = x^3+3*x^2*y+3*x*y^2+y^3
// Here is a link for more information about the process of calculating the binomial: https://en.wikipedia.org/wiki/Binomial_theorem

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("The program will evaluate: (x+y)^n");
		System.out.print("Enter a natural number n: ");
		int n = kb.nextInt(), coefficient;
		
		for (int k = 0; k <= n; k++) {
			coefficient = factorial(n) / ( factorial(k)*factorial(n-k) );
			if (k == 0 || k == n) {
				System.out.print(k==0?"x^" + n + " + ":"y^" + n);
			} else {
				System.out.print(coefficient + (n-k==1?"*x":"*x^"+(n-k)) + (k==1?"*y":"*y^" + k) +" + ");
			}
		}
		
	}
	
	public static int factorial(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
