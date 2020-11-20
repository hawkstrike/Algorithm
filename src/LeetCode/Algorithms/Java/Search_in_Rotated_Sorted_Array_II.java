package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class Search_in_Rotated_Sorted_Array_II {
	public static void main(String[] args) {
		int[] nums = {2, 5, 6, 0, 0, 1, 2};
		int target = 0;
		
		System.out.println(search(nums, target));
	}
	
	public static boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (nums[mid] == target) {
				return true;
			}
			
			if (nums[mid] == nums[right]) {
				right--;
			} else if (nums[mid] < nums[right]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		
		return false;
	}
}