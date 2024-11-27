package paket4e;

import java.util.*;

public class ProblemRepeat {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n;
		do {
			System.out.print("Enter the length: ");
			n = kb.nextInt();
		} while (n <= 0 || n > 10);
		
		int[] nums = new int[n];
		
		for (int i = 0; i < n; i++) nums[i] = kb.nextInt();
		
		
		boolean[] printed = new boolean[n];

        System.out.println("Numbers that occurred more than once:");
        
        for (int i = 0; i < n; i++) {
            if (printed[i]) continue;
            
            int count = 1;
            
            for (int j = i + 1; j < n; j++)
                if (nums[i] == nums[j]) {
                    count++;
                    printed[j] = true;
                }
            
            if (count > 1) {
                System.out.println(nums[i]);
                printed[i] = true;
            }
        }
        
	}

}
