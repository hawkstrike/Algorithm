package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/arithmetic-slices/
public class Arithmetic_Slices {
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		
		System.out.println(numberOfArithmeticSlices(A));
	}
	
	public static int numberOfArithmeticSlices(int[] A) {
		int length = A.length;
		int[] dp = new int[length];
		int sum = 0;
		
		for (int i = 2; i < length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp[i] = dp[i - 1] + 1;
				sum += dp[i];
			}
		}
		
		return sum;
	}
}