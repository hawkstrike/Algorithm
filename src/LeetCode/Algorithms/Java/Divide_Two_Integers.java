package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/divide-two-integers/
public class Divide_Two_Integers {
	public static void main(String[] args) {
		int dividend = 10;
		int divisor = 3;
		
		System.out.println(divide(dividend, divisor));
	}
	
	public static int divide(int dividend, int divisor) {
		if (dividend == 1 << 31 && divisor == -1) {
			return (1 << 31) - 1;
		}
		
		int a = Math.abs(dividend);
		int b = Math.abs(divisor);
		int result = 0;
		
		for (int i = 31; i >= 0; i--) {
			if ((a >>> i) - b >= 0) {
				result += 1 << i;
				a -= b << i;
			}
		}
		
		return ((dividend > 0) == (divisor > 0)) ? result : -result;
	}
}