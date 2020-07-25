package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class Find_Minimum_in_Rotated_Sorted_Array_II {
	public static void main(String[] args) {
		int[] nums = {1, 3, 5};
		
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			if (nums[mid] < nums[right]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right--;
			}
		}
		
		return nums[left];
	}
}