package testove;

import java.util.*;

public class Zada4a {
	
	public static ArrayList<Integer> getDivisors(int n) {
		ArrayList<Integer> divisors = new ArrayList<>();
		for (int i = 1; i <= Math.abs(n); i++) {
			if (n%i==0) {
				divisors.add(i);
			}
		}
		return divisors;
	}
	
	public static boolean checkRoot(double x, ArrayList<Integer> coefficients, ArrayList<Integer> powers) {
		double sum = 0;
		for (int i = 0; i < powers.size(); i++) {
			sum += coefficients.get(i)*Math.pow(x, powers.get(i));
		}
		return Math.abs(sum) < 1e-9;
	}
	
	public static void printInfo() {
		System.out.println("This is a rational root finder of any polynomial equation. *Note: the coefficient must be integers!!!");
		System.out.println("You need to enter the values like this: coefficient,power (for every term)");
		System.out.println( "For example: 5x^3 - 9x + 1 = 0");
		System.out.println("You would write: 5,3 then -9,1 then 1,0");
		System.out.println("Powers can't repeat!");
		System.out.println("When ready with all coefficient - write \"exit\".");
		System.out.println("-----------------------------------------------------------");
	}

	public static void main(String[] args) {
		printInfo();
		
		ArrayList<Double> roots = new ArrayList<>();
		ArrayList<Integer> coefficients = new ArrayList<>();
		ArrayList<Integer> powers = new ArrayList<>();
		ArrayList<Integer> power_0_coeff_divisors = new ArrayList<>();
		ArrayList<Integer> max_power_coeff_divisors = new ArrayList<>();
		
		
		Scanner kb = new Scanner(System.in);
		String term;
		do {
			term = kb.nextLine().replaceAll(" ", "");
			
			if (!term.toLowerCase().equals("exit")) {
				coefficients.add(Integer.parseInt(term.split("," , 2)[0]));
				powers.add(Integer.parseInt(term.split("," , 2)[1]));
			} else {
				System.out.println("Inputs successfully entered...");
			}
			
		} while (!term.toLowerCase().equals("exit"));
		
		
		while (Collections.min(powers) != 0) {
			if (!roots.contains(0.0)) {
				roots.add(0.0);
			}
			for (int i = 0; i < powers.size(); i++) {
				powers.set(i, powers.get(i) - 1);
			}
		}

		power_0_coeff_divisors = getDivisors(coefficients.get(powers.indexOf(0)));
		max_power_coeff_divisors = getDivisors(coefficients.get(powers.indexOf(Collections.max(powers))));
		
		for (int i = 0; i < power_0_coeff_divisors.size(); i++) {
			for (int j = 0; j < max_power_coeff_divisors.size(); j++) {
				double x = (double)power_0_coeff_divisors.get(i)/max_power_coeff_divisors.get(j);
				if (checkRoot(x, coefficients, powers) && !roots.contains(x)) {
					roots.add(x);
				}
				if (checkRoot(-x, coefficients, powers) && !roots.contains(-x)) {
					roots.add(-x);
				}
			}
		}
		
		System.out.println("Rational roots of the polynomial equation: " + "\n");
		
        for (double num : roots) {
        	System.out.print("x = ");
            if (num == Math.floor(num)) {
                System.out.print((int)num);
            } else {
                System.out.print(num);
            }
            System.out.println();
        }
	}
}
