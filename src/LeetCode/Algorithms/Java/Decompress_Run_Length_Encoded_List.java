package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/decompress-run-length-encoded-list/
public class Decompress_Run_Length_Encoded_List {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};

		int[] result = decompressRLElist(nums);

		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public static int[] decompressRLElist(int[] nums) {
		int resultLength = 0;
		int index = 0;

		for (int i = 0; i < nums.length; i += 2) {
			resultLength += nums[i];
		}

		int[] result = new int[resultLength];

		for(int i = 0; i < nums.length; i += 2) {
			int freq = nums[i];
			int val = nums[i + 1];

			Arrays.fill(result, index, index + freq, val);
			index += freq;
		}

		return result;
	}
}