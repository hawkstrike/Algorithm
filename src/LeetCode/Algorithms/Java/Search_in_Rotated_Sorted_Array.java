package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class Search_in_Rotated_Sorted_Array {
	public static void main(String[] args) {
		int[] nums = {};// {4, 5, 6, 7, 0, 1, 2};
		int target = 5;
		
		System.out.println(search(nums, target));
	}
	
	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		
		if (high < 0) {
			return -1;
		}
		
		while (low < high) {
			int mid = low + (high - low) / 2;
			
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		
		int pivot = low;
		low = 0;
		high = nums.length - 1;
		
		if (target >= nums[pivot] && target <= nums[high]) {
			low = pivot;
		} else {
			high = pivot;
		}
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
		
		/*int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (nums[low] == target) {
				return low;
			} else if (nums[high] == target) {
				return high;
			} else if (nums[mid] == target) {
				return mid;
			}
			
			if (nums[low] <= target && nums[mid] > target) {
				high = mid - 1;
			} else if (nums[low] > nums[mid] && (nums[low] <= target || nums[mid] > target)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return -1;*/
	}
}