package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/rotate-array/
public class Rotate_Array {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		
		rotate(nums, k);
		
		for (int n : nums) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static void rotate(int[] nums, int k) {
		k %= nums.length;
		
		reverseRotate(nums, 0, nums.length - 1);
		reverseRotate(nums, 0, k - 1);
		reverseRotate(nums, k, nums.length - 1);
		
		/*k %= nums.length;
		
		int temp = 0;
		int n = 0;
		
		for (int i = 0; i < k; i++) {
			n = nums[nums.length - 1];
			
			for (int j = 0; j < nums.length; j++) {
				temp = nums[j];
				nums[j] = n;
				n = temp;
			}
		}*/
	}
	
	public static void reverseRotate(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			
			start++;
			end--;
		}
	}
}