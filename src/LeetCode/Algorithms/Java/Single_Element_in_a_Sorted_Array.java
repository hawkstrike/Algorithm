package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class Single_Element_in_a_Sorted_Array {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
		
		System.out.println(singleNonDuplicate(nums));
	}
	
	public static int singleNonDuplicate(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			if (nums[mid] == nums[mid ^ 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return nums[left];
	}
}