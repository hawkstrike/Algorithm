package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/island-perimeter/
public class Island_Perimeter {
	public static void main(String[] args) {
		int[][] grid = {{0, 1, 0, 0},
						{1, 1, 1, 0,},
						{0, 1, 0, 0,},
						{1, 1, 0, 0,}};
		//int[][] grid = {{1}, {0}};
		
		System.out.println(islandPerimeter(grid));
	}
	
	public static int islandPerimeter(int[][] grid) {
		int result = 0;
		int m = grid.length;
		int n = grid[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					continue;
				}
				
				if (i == 0 || grid[i - 1][j] == 0) {
					result++;
				}
				if (i == m - 1 || grid[i + 1][j] == 0) {
					result++;
				}
				if (j == 0 || grid[i][j - 1] == 0) {
					result++;
				}
				if (j == n - 1 || grid[i][j + 1] == 0) {
					result++;
				}
			}
		}
		
		return result;
		/*int result = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					result = bfs(grid, i, j);
					
					return result;
				}
			}
		}
		
		return result;*/
	}
	
	public static int bfs(int[][] grid, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int[] coor = {x, y};
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int perimeter = 0;
		
		q.offer(coor);
		grid[x][y] = -1;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int currX = curr[0] + dx[i];
				int currY = curr[1] + dy[i];
				
				if (currX >= 0 && currX <= grid.length - 1 && currY >= 0 && currY <= grid[0].length - 1) {
					if (grid[currX][currY] == 1) {
						q.offer(new int[]{currX, currY});
						grid[currX][currY] = -1;
					}
					
					if (grid[currX][currY] == 0) {
						perimeter++;
					}
				} else {
					perimeter++;
				}
			}
		}
		
		return perimeter;
	}
}