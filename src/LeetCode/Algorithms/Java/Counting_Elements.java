package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
public class Counting_Elements {
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2}; // {1, 3, 2, 3, 5, 0}; // {1, 1, 3, 3, 5, 5, 7, 7}; // {1, 2, 3};
		
		System.out.println(countElements(arr));
	}
	
	public static int countElements(int[] arr) {
		HashSet<Integer> hashSet = new HashSet<>();
		int result = 0;
		
		for (int n : arr) {
			hashSet.add(n);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (hashSet.contains(arr[i] + 1)) {
				result++;
			}
		}
		
		return result;
	}
}