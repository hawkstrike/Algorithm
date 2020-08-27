package LeetCode.Algorithms.Java;

import java.util.TreeMap;

// https://leetcode.com/problems/add-binary/
public class Find_Right_Interval {
	public static void main(String[] args) {
		//int[][] intervals = {{1, 2}};
		int[][] intervals = {{3, 4},
							{2, 3},
							{1, 2}};
		int[] result = findRightInterval(intervals);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] findRightInterval(int[][] intervals) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		
		for (int i = 0; i < intervals.length; i++) {
			treeMap.put(intervals[i][0], i);
		}
		
		int[] result = new int[intervals.length];
		
		for (int i = 0; i < result.length; i++) {
			Integer key = treeMap.ceilingKey(intervals[i][1]);
			
			result[i] = (key == null) ? -1 : treeMap.get(key);
		}
		
		return result;
	}
}