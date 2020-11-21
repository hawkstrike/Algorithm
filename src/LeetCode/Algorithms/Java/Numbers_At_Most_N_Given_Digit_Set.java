package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
public class Numbers_At_Most_N_Given_Digit_Set {
	public static void main(String[] args) {
		String[] digits = {"1", "3", "5", "7"};
		int n = 100;
		
		System.out.println(atMostNGivenDigitSet(digits, n));
	}
	
	public static int atMostNGivenDigitSet(String[] digits, int n) {
		String s = Integer.toString(n);
		int k = s.length();
		int[] dp = new int[k + 1];
		
		dp[k] = 1;
		
		for (int i = k - 1; i >= 0; i--) {
			int si = s.charAt(i) - '0';
			
			for (String digit : digits) {
				if (Integer.parseInt(digit) < si) {
					dp[i] += Math.pow(digit.length(), k - i - 1);
				} else if (Integer.parseInt(digit) == si) {
					dp[i] += dp[i + 1];
				}
			}
		}
		
		for (int i = 1; i < k; i++) {
			dp[0] += Math.pow(digits.length, i);
		}
		
		return dp[0];
	}
}