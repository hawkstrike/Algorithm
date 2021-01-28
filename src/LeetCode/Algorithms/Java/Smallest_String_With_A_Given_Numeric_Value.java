package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
public class Smallest_String_With_A_Given_Numeric_Value {
	public static void main(String[] args) {
		int n = 3;
		int k = 27;
		
		System.out.println(getSmallestString(n, k));
	}
	
	public static String getSmallestString(int n, int k) {
		char[] arr = new char[n];
		
		Arrays.fill(arr, 'a');
		
		k -= n;
		
		while (k > 0) {
			arr[--n] += Math.min(25, k);
			k -= Math.min(25, k);
		}
		
		return String.valueOf(arr);
	}
}