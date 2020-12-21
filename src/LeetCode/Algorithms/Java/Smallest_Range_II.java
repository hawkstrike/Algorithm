package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/smallest-range-ii/
public class Smallest_Range_II {
	public static void main(String[] args) {
		int[] A = {1};
		int K = 0;
		
		System.out.println(smallestRangeII(A, K));
	}
	
	public static int smallestRangeII(int[] A, int K) {
		Arrays.sort(A);
		
		int length = A.length;
		int result = A[length - 1] - A[0];
		
		for (int i = 0; i < A.length - 1; i++) {
			int a = A[i];
			int b = A[i + 1];
			int high = Math.max(A[length - 1] - K, a + K);
			int low = Math.min(A[0] + K, b - K);
			
			result = Math.min(result, high - low);
		}
		
		return result;
	}
}