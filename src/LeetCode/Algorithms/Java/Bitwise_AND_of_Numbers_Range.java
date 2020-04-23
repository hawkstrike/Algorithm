package LeetCode.Algorithms.Java;

import java.util.Hashtable;

// https://leetcode.com/problems/bitwise-and-of-numbers-range/
public class Bitwise_AND_of_Numbers_Range {
	public static void main(String[] args) {
		int m = 5;
		int n = 7;
		
		System.out.println(rangeBitwiseAnd(m, n));
	}
	
	public static int rangeBitwiseAnd(int m, int n) {
		while (n > m) {
			n = n & n -1;
		}
		
		return m & n;
	}
}