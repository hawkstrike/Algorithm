package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/sort-array-by-parity/
public class Sort_Array_By_Parity {
	public static void main(String[] args) {
		int[] A = {3, 1, 2, 4};
		int[] result = sortArrayByParity(A);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] sortArrayByParity(int[] A) {
		Integer[] B = new Integer[A.length];
		
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		
		Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));
		
		for (int i = 0; i < A.length; i++) {
			A[i] = B[i];
		}
		
		return A;
	}
}