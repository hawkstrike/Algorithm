package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/sort-colors/
public class Sort_Colors {
	public static void main(String[] args) {
		int[] nums = {2, 0, 2, 1, 1, 0};
		
		sortColors(nums);
		
		for (int n : nums) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static void sortColors(int[] nums) {
		int i = 0;
		int j = 0;
		int k = nums.length;
		
		while (j < k) {
			if (nums[j] == 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j++;
			} else if (nums[j] == 2) {
				k--;
				int temp = nums[j];
				nums[j] = nums[k];
				nums[k] = temp;
			} else {
				j++;
			}
		}
	}
}