package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/first-missing-positive/
public class First_Missing_Positive {
	public static void main(String[] args) {
		int[] nums = {1, 2, 0};
		
		System.out.println(firstMissingPositive(nums));
	}
	
	public static int firstMissingPositive(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int index = 1;
		
		while (set.contains(index)) {
			index++;
		}
		
		return index;
	}
}