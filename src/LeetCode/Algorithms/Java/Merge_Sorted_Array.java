package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
public class Merge_Sorted_Array {
	public static void main(String[] args) {
		/*int[] nums1 = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = {2, 5, 6};
		int n = 3;*/
		/*int[] nums1 = {0};
		int m = 0;
		int[] nums2 = {1};
		int n = 1;*/
		/*int[] nums1 = {0, 0, 0, 0, 0};
		int m = 0;
		int[] nums2 = {1, 2, 3, 4, 5};
		int n = 5;*/
		/*int[] nums1 = {1};
		int m = 1;
		int[] nums2 = {};
		int n = 0;*/
		int[] nums1 = {0};
		int m = 0;
		int[] nums2 = {1};
		int n = 1;
		
		merge(nums1, m, nums2, n);
		
		for (int num : nums1) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int length = nums1.length - 1;
		
		m--;
		n--;
		
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n]) {
				nums1[length--] = nums1[m--];
			} else {
				nums1[length--] = nums2[n--];
			}
		}
		
		while (n >= 0) {
			nums1[length--] = nums2[n--];
		}
	}
}