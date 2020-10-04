package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/remove-covered-intervals/
public class Remove_Covered_Intervals {
	public static void main(String[] args) {
		int[][] intervals = {{1, 4},
							{3, 6},
							{2, 8}};
		
		System.out.println(removeCoveredIntervals(intervals));
	}
	
	public static int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> ((a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]));
		
		int i = 0;
		int j = 1;
		int covered = 0;
		
		while (j < intervals.length) {
			if (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]) {
				covered++;
			} else {
				i = j;
			}
			
			j++;
		}
		
		return intervals.length - covered;
	}
}