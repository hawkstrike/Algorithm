package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/kth-missing-positive-number/
public class Kth_Missing_Positive_Number {
	public static void main(String[] args) {
		/*int[] arr = {2, 3, 4, 7, 11};
		int k = 5;*/
		int[] arr = {1, 2, 3, 4};
		int k = 2;
		
		System.out.println(findKthPositive(arr, k));
	}
	
	public static int findKthPositive(int[] arr, int k) {
		HashSet<Integer> hashSet = new HashSet<>();
		
		for (int n : arr) {
			hashSet.add(n);
		}
		
		int number = 1;
		
		while (k > 0) {
			if (!hashSet.contains(number)) {
				k--;
			}
			
			if (k == 0) {
				break;
			}
			
			number++;
		}
		
		return number;
	}
}