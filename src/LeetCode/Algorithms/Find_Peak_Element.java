package LeetCode.Algorithms;

// https://leetcode.com/problems/find-peak-element/
public class Find_Peak_Element {
	public static void main(String[] args){
		int[] nums = {1, 2}; // {5, 4, 3, 2, 1, 0, 10, 9, 8}; // {1, 2, 3, 1, 2, 3, 5, 4, 2, 1, 6, 7}; // {1, 2, 1, 3, 5, 6, 4}; // {1, 2, 3, 1};

		System.out.println(findPeakElement(nums));
	}
	
	public static int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return i;
			}
		}
		
		return nums.length - 1;
	}
}