package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/ugly-number-ii/
public class Ugly_Number_II {
	public static void main(String[] args) {
		int n = 10;
		
		System.out.println(nthUglyNumber(n));
	}
	
	public static int nthUglyNumber(int n) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] dp = new int[n];
		
		dp[0] = 1;
		
		for (int index = 1; index < n; index++) {
			dp[index] = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
			
			if (dp[index] == dp[i] * 2) {
				i++;
			}
			if (dp[index] == dp[j] * 3) {
				j++;
			}
			if (dp[index] == dp[k] * 5) {
				k++;
			}
		}
		
		return dp[n - 1];
	}
}