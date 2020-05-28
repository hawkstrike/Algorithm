package LeetCode.Algorithms.Java;

import java.util.Hashtable;

// https://leetcode.com/problems/counting-bits/
public class Counting_Bits {
	public static void main(String[] args) {
		int num = 5;
		int[] result = countBits(num);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] countBits(int num) {
		int[] result = new int[num + 1];
		
		for (int i = 0; i <= num; i++) {
			result[i] = Integer.bitCount(i);
		}
		
		return result;
	}
}