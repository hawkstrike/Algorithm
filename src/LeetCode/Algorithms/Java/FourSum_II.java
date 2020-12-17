package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/4sum-ii/
public class FourSum_II {
	public static void main(String[] args) {
		int[] A = {1, 2};
		int[] B = {-2, -1};
		int[] C = {-1, 2};
		int[] D = {0, 2};
		
		System.out.println(fourSumCount(A, B, C, D));
	}
	
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int result = 0;
		
		for (int a : A) {
			for (int b : B) {
				int sum = a + b;
				
				hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
			}
		}
		
		for (int c : C) {
			for (int d : D) {
				int sum = c + d;
				
				result += hashMap.getOrDefault(-sum, 0);
			}
		}
		
		return result;
	}
}