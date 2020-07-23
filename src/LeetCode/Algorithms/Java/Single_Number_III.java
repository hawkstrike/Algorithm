package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/single-number-iii/
public class Single_Number_III {
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] result = singleNumber(nums);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] singleNumber(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		
		for (int n : nums) {
			if (hashSet.contains(n)) {
				hashSet.remove(n);
			} else {
				hashSet.add(n);
			}
		}
		
		return hashSet.stream().mapToInt(n -> n).toArray();
		
		/*int[] result = new int[2];
		int xor = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			xor ^= nums[i];
		}
		
		int bit = xor & ~(xor - 1);
		int num1 = 0;
		int num2 = 0;
		
		for (int n : nums) {
			if ((n & bit) > 0) {
				num1 ^= n;
			} else {
				num2 ^= n;
			}
		}
		
		result[0] = num1;
		result[1] = num2;
		
		return result;*/
	}
}