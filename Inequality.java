import java.util.*;

public class Example1 {
	
	public static void main(String[] args) {
		// Трябва да намерим решенията на неравенството ax^2 < b
		Scanner kb = new Scanner(System.in);
		System.out.print("Моля въведете a: ");
		int a = kb.nextInt();
		System.out.print("Моля въведете b: ");
		int b = kb.nextInt();
		
		//ax^2 - b
		double x1 = Math.sqrt((double)b/a);
		double x2 = -Math.sqrt((double)b/a);
		
		if (a <= 0 && b > 0) {
			System.out.println("Всяко реално x е решение на неравенството!");
		} else if (a >= 0 && b < 0) {
			System.out.println("Неравенството няма решения!");
		} else if (a < 0 && b < 0) {
			System.out.println("x е в интервалите (-inf," + x2 + ") U (" + x1 + ",+inf)");
		} else if (a > 0 &&  b > 0) {
			System.out.println("x е в интервала (" + x2 + "," + x1 + ")");
		} else {
			System.out.println("Неравенството няма решения!");
		}
	}
}
