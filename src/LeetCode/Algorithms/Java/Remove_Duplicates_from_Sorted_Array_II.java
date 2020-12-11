package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class Remove_Duplicates_from_Sorted_Array_II {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3};
		
		System.out.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		
		int index = 0;
		
		for (int n : nums) {
			if (index < 2 || n > nums[index - 2]) {
				nums[index++] = n;
			}
		}
		
		return index;
	}
}