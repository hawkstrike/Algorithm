package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
public class Inset_Interval {
	public static void main(String[] args) {
		int[][] intervals = {{1, 3},
							{6, 9}};
		int[] newInterval = {2, 5};
		int[][] result = insert(intervals, newInterval);
		
		for (int[] arr : result) {
			for (int n : arr) {
				System.out.print(n + " ");
			}
			
			System.out.println();
		}
	}
	
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new LinkedList<>();
		int i = 0;
		
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			list.add(intervals[i++]);
		}
		
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			i++;
		}
		
		list.add(newInterval);
		
		while (i < intervals.length) {
			list.add(intervals[i++]);
		}
		
		return list.toArray(new int[list.size()][2]);
	}
}