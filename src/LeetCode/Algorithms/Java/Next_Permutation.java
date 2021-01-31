package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/next-permutation/
public class Next_Permutation {
	public static void main(String[] args) {
		//int[] nums = {1, 2, 3};
		int[] nums = {3, 2, 1};
		
		nextPermutation(nums);
		
		for (int n : nums) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static void nextPermutation(int[] nums) {
		int pivot = -1;
		
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				pivot = i - 1;
				
				break;
			}
		}
		
		if (pivot != -1) {
			int nextPrefix = 0;
			
			for (int i = nums.length - 1; i > 0; i--) {
				if (nums[pivot] < nums[i]) {
					nextPrefix = i;
					
					break;
				}
			}
			
			swap(nums, pivot, nextPrefix);
		}
		
		int start = pivot + 1;
		int end = nums.length - 1;
		
		while (start < end) {
			swap(nums, start++, end--);
		}
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		
		nums[i] = nums[j];
		nums[j] = temp;
	}
}