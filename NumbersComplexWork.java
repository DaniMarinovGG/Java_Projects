package testove;

import java.util.*;

public class NumbersComplexWork {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		
		Complex a = new Complex(kb.nextDouble(), kb.nextDouble());
		Complex b = new Complex(kb.nextDouble(), kb.nextDouble());
		Complex c = new Complex(kb.nextDouble(), kb.nextDouble());
		
		Complex[] roots = new Complex[2];
		
		roots[0] = b.opposite().add(b.pow(2).subtract(new Complex(4, 0).multiply(a).multiply(c)).root(2)[0]).divide(new Complex(2, 0).multiply(a));
		roots[1] = b.opposite().subtract(b.pow(2).subtract(new Complex(4, 0).multiply(a).multiply(c)).root(2)[0]).divide(new Complex(2, 0).multiply(a));

		System.out.println("x1 = " + roots[0].value_str);
		System.out.println("x2 = " + roots[1].value_str);
	}

}
