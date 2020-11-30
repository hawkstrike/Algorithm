package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/the-skyline-problem/
public class The_Skyline_Problem {
	public static void main(String[] args) {
		int[][] buildings = {{2, 9, 10},
							{3, 7, 15},
							{5, 12, 12},
							{15, 20, 10},
							{19, 24, 8}};
		List<List<Integer>> result = getSkyline(buildings);
		
		for (List<Integer> list : result) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> result = new LinkedList<>();
		List<int[]> heightList = new LinkedList<>();
		
		for (int[] building : buildings) {
			heightList.add(new int[]{building[0], -building[2]});
			heightList.add(new int[]{building[1], building[2]});
		}
		
		Collections.sort(heightList, (a, b) -> {
			return (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1];
		});
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (b - a));
		int prev = 0;
		
		priorityQueue.offer(0);
		
		for (int[] height : heightList) {
			if (height[1] < 0) {
				priorityQueue.offer(-height[1]);
			} else {
				priorityQueue.remove(height[1]);
			}
			
			int curr = priorityQueue.peek();
			
			if (prev != curr) {
				result.add(Arrays.asList(height[0], curr));
				prev = curr;
			}
		}
		
		return result;
	}
}