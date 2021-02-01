package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/number-of-1-bits/
public class Number_of_1_Bits {
	public static void main(String[] args) {
		//int n = 00000000000000000000000000001011;
		int n = 00000000000000000000000010000000;
		//int n = 1111111101;
		
		System.out.println(hammingWeight(n));
	}
	
	public static int hammingWeight(int n) {
		return Integer.bitCount(n);
	}
}