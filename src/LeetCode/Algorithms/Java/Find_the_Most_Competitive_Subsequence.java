package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/find-the-most-competitive-subsequence/
public class Find_the_Most_Competitive_Subsequence {
	public static void main(String[] args) {
		int[] nums = {3, 5, 2, 6};
		int k = 2;
		int[] result = mostCompetitive(nums, k);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] mostCompetitive(int[] nums, int k) {
		int[] arr = new int[k];
		int length = nums.length;
		int j = 0;
		
		for (int i = 0; i < length; i++) {
			while (j > 0 && arr[j - 1] > nums[i] && j - 1 + length - i >= k) {
				j--;
			}
			
			if (j < k) {
				arr[j++] = nums[i];
			}
		}
		
		return arr;
	}
}