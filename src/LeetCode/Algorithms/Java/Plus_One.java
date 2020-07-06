package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/plus-one/
public class Plus_One {
	public static void main(String[] args) {
		int[] digits = {1, 2, 3};
		int[] result = plusOne(digits);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] plusOne(int[] digits) {
		int plusOne = 1;
		
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += plusOne;
			
			if (digits[i] <= 9) {
				return digits;
			}
			
			digits[i] = 0;
		}
		
		int[] result = new int[digits.length + 1];
		
		result[0] = 1;
		
		return result;
	}
}