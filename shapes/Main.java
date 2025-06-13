package boqnkataZada4ka;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		
		// for the triangle
		
		double a, b, c;
		do {
			System.out.print("Enter a: ");
			a = kb.nextDouble();
			System.out.println("Enter b: ");
			b = kb.nextDouble();
			System.out.println("Enter c: ");
			c = kb.nextDouble();
			if (a <= 0 || b <= 0 || c <= 0) {
				System.out.println("Please enter positive real numbers!");
			}
		} while (a <= 0 || b <= 0 || c <= 0);
		
		Triangle t = new Triangle(a, b, c);
		
		t.printInfo();
		
		kb.close();
		// it is similiar with the circle and rectangle
	}

}
