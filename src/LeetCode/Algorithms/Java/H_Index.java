package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/
public class H_Index {
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		
		System.out.println(hIndex(citations));
	}
	
	public static int hIndex(int[] citations) {
		Arrays.sort(citations);
		
		int result = 0;
		int left = 0;
		int right = citations.length - 1;
		int length = citations.length;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (citations[mid] >= (length - mid)) {
				result = (length - mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}
}