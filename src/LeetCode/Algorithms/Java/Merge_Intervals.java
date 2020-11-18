package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class Merge_Intervals {
	public static void main(String[] args) {
		/*int[][] intervals = {{1, 3},
							{2, 6},
							{8, 10},
							{15, 18}};*/
		int[][] intervals = {{1, 4},
							{2, 3}};
		int[][] result = merge(intervals);
		
		for (int[] arr : result) {
			for (int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
		
		List<int[]> list = new LinkedList<>();
		int front = intervals[0][0];
		int rear = intervals[0][1];
		
		for (int i = 1; i < intervals.length; i++) {
			if (rear > intervals[i][1]) {
				continue;
			}
			
			if (rear < intervals[i][0]) {
				list.add(new int[]{front, rear});
				
				front = intervals[i][0];
			}
			
			rear = intervals[i][1];
		}
		
		list.add(new int[]{front, rear});
		
		return list.toArray(new int[][]{});
	}
}