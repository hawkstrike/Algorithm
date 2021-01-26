package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-minimum-effort/
public class Path_With_Minimum_Effort {
	public static class coordinate {
		int x;
		int y;
		int diff;
		
		public coordinate(int x, int y, int diff) {
			this.x = x;
			this.y = y;
			this.diff = diff;
		}
	}
	
	public static void main(String[] args) {
		int[][] heights = {{1, 2, 2},
							{3, 8, 2},
							{5, 3, 5}};
		
		System.out.println(minimumEffortPath(heights));
	}
	
	public static int minimumEffortPath(int[][] heights) {
		PriorityQueue<coordinate> priorityQueue = new PriorityQueue<>((a, b) -> a.diff - b.diff);
		int[][] maxDiffArr = new int[heights.length][heights[0].length];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int[] data : maxDiffArr) {
			Arrays.fill(data, Integer.MAX_VALUE);
		}
		
		priorityQueue.offer(new coordinate(0, 0, 0));
		maxDiffArr[0][0] = 0;
		
		while (!priorityQueue.isEmpty()) {
			coordinate curr = priorityQueue.poll();
			
			if (curr.x == heights.length - 1 && curr.y == heights[0].length - 1) {
				return curr.diff;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int currX = curr.x + dx[i];
				int currY = curr.y + dy[i];
				
				if (currX >= 0 && currX < heights.length && currY >= 0 && currY < heights[0].length) {
					int maxDiff = Math.max(curr.diff, Math.abs(heights[currX][currY] - heights[curr.x][curr.y]));
					
					if (maxDiff < maxDiffArr[currX][currY]) {
						maxDiffArr[currX][currY] = maxDiff;
						priorityQueue.offer(new coordinate(currX, currY, maxDiff));
					}
				}
			}
		}
		
		return -1;
	}
}