package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class Shortest_Path_in_Binary_Matrix {
	public static class coor {
		int x;
		int y;
		int path;
		
		public coor(int x, int y, int path) {
			this.x = x;
			this.y = y;
			this.path = path;
		}
	}
	
	public static void main(String[] args) {
		/*int[][] grid = {{0, 1},
						{1, 0}};*/
		/*int[][] grid = {{0, 0, 0},
						{1, 1, 0},
						{1, 1, 0}};*/
		int[][] grid = {{1, 0, 0},
						{1, 1, 0},
						{1, 1, 0}};
		
		System.out.println(shortestPathBinaryMatrix(grid));
	}
	
	public static int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] == 1) {
			return -1;
		}
		
		Queue<coor> queue = new LinkedList<>();
		int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
		int length = grid.length;
		
		queue.offer(new coor(0, 0, 1));
		grid[0][0] = -1;
		
		while (!queue.isEmpty()) {
			coor c = queue.poll();
			
			if (c.x == length - 1 && c.y == length - 1) {
				return c.path;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];
				
				if (currX >= 0 && currX < length && currY >= 0 && currY < length && grid[currX][currY] == 0) {
					queue.offer(new coor(currX, currY, c.path + 1));
					grid[currX][currY] = -1;
				}
			}
		}
		
		return -1;
	}
}