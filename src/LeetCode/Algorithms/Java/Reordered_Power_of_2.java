package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/reordered-power-of-2/
public class Reordered_Power_of_2 {
	public static void main(String[] args) {
		int N = 1;
		
		System.out.println(reorderedPowerOf2(N));
	}
	
	public static boolean reorderedPowerOf2(int N) {
		char[] arr = Integer.toString(N).toCharArray();
		
		Arrays.sort(arr);
		
		for (int i = 0; i < 30; i++) {
			char[] arr2 = Integer.toString(1 << i).toCharArray();
			
			Arrays.sort(arr2);
			
			if (Arrays.equals(arr, arr2)) {
				return true;
			}
		}
		
		return false;
	}
}