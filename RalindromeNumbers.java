import java.util.*;

// this program will check if a number is palindrome (number should be bigger or equal than 1 and less or equal to 10000000

public class Example1 {
	
	public static void main(String[] args) {
		try {
			boolean is_a_palindrome = true;
			Scanner kb = new Scanner(System.in);
			int number = kb.nextInt();
			String[] digits = Integer.toString(number).split("");
			
			if (number >= 1 && number <= 10000000) {
				for (int i = 0; i < Math.round((double)digits.length / 2); i++) {
					if (!digits[i].equals(digits[digits.length - 1 - i])) {
						System.out.println(number + " is NOT a palindrome");
						is_a_palindrome = false;
						break;
					}
				} if (is_a_palindrome) {
					System.out.println(number + " is a palindrome");
				}
				
			} else {
				System.out.println("Incorrectly entered number!");
			}
			
		} catch (Exception e) {
			System.out.println("Incorrectly entered number!");
		}
	}
}
