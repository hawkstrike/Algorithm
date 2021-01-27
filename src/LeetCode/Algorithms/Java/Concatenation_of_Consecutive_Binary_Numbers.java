package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
public class Concatenation_of_Consecutive_Binary_Numbers {
	public static void main(String[] args) {
		//int n = 1;
		int n = 3;
		
		System.out.println(concatenatedBinary(n));
	}
	
	public static int concatenatedBinary(int n) {
		long result = 0;
		int pow = 0;
		
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				pow++;
			}
			
			result = (result << pow | i) % 1_000_000_007;
		}
		
		return (int) result;
	}
}