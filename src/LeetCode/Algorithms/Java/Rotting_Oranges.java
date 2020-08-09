package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
public class Rotting_Oranges {
	public static class coordinate {
		int x;
		int y;
		
		coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		int[][] grid = {{2, 1, 1},
						{1, 1, 0},
						{0, 1, 1}};
		/*int[][] grid = {{2, 1, 1},
						{0, 1, 1},
						{1, 0, 1}};*/
		//int[][] grid = {{0, 2}};
		//int[][] grid = {{1}};
		
		System.out.println(orangesRotting(grid));
	}
	
	public static int orangesRotting(int[][] grid) {
		Queue<coordinate> queue = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int xLength = grid.length;
		int yLength = grid[0].length;
		int size = 0;
		int minutes = 0;
		
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yLength; j++) {
				if (grid[i][j] == 2) {
					queue.add(new coordinate(i, j));
				}
			}
		}
		
		size = queue.size();
		
		while (!queue.isEmpty()) {
			for (int index = 0; index < size; index++) {
				coordinate curr = queue.poll();
				
				for (int i = 0; i < dx.length; i++) {
					int currX = curr.x + dx[i];
					int currY = curr.y + dy[i];
					
					if (currX >= 0 && currY >= 0 && currX < xLength && currY < yLength && grid[currX][currY] == 1) {
						queue.add(new coordinate(currX, currY));
						grid[currX][currY] = 2;
					}
				}
			}
			
			size = queue.size();
			
			if (size != 0) {
				minutes++;
			}
		}
		
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yLength; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		
		return minutes;
	}
}