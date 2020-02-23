package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
public class Two_Sum {
	public static void main(String[] args) {
		int[] nums = {-1, -2, -3, -4, -5}; // {3, 2, 4} // {3, 3} // {0, 4, 3, 0} // {-3, 4, 3, 90}
		int target = -8;

		int[] result = twoSum(nums, target);

		for(int x : result) {
			System.out.print(x + " ");
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		for(int i = 0; i < nums.length; i++)
			hashMap.put(nums[i], i);

		for(int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			Integer value = hashMap.get(diff);

			if(value != null && !value.equals(i))
				return new int[]{i, value};
		}

		return new int[]{};
	}
}