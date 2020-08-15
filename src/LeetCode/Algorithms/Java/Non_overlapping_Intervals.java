package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/
public class Non_overlapping_Intervals {
	public static void main(String[] args) {
		int[][] intervals = {{1, 2},
							{2, 3},
							{3, 4},
							{1, 3}};
		
		System.out.println(eraseOverlapIntervals(intervals));
	}
	
	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		
		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
		int result = 0;
		int next = Integer.MAX_VALUE;
		
		for (int i = intervals.length - 1; i >= 0; i--) {
			if (next < intervals[i][1]) {
				result++;
			} else {
				next = intervals[i][0];
			}
		}
		
		return result;
	}
}