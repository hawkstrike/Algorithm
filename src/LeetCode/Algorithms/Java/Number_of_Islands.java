package LeetCode.Algorithms.Java;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/
public class Number_of_Islands {
	public static void main(String[] args) {
		/*char[][] grid = {{'1', '1', '1', '1', '0'},
						{'1', '1', '0', '1', '0'},
						{'1', '1', '0', '0', '0'},
						{'0', '0', '0', '0', '0'}};*/
		char[][] grid = {{'1', '1', '0', '0', '0'},
						{'1', '1', '0', '0', '0'},
						{'0', '0', '1', '0', '0'},
						{'0', '0', '0', '1', '1'}};
		
		System.out.println(numIslands(grid));
	}
	
	public static int numIslands(char[][] grid) {
		int result = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					result++;
				}
			}
		}
		
		return result;
	}
	
	public static void bfs(char[][] grid, int x, int y) {
		Queue<Pair<Integer, Integer>> q = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		q.add(new Pair<>(x, y));
		
		while (!q.isEmpty()) {
			Pair<Integer, Integer> pair = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int currX = pair.getKey() + dx[i];
				int currY = pair.getValue() + dy[i];
				
				if (currX >= 0 && currY >= 0 && currX < grid.length && currY < grid[0].length && grid[currX][currY] == '1') {
					grid[currX][currY] = '0';
					q.add(new Pair<>(currX, currY));
				}
			}
		}
	}
}