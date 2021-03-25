package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class Pacific_Atlantic_Water_Flow {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 2, 3, 5},
						{3, 2, 3, 4, 4},
						{2, 4, 5, 3, 1},
						{6, 7, 1, 4, 5},
						{5, 1, 1, 2, 4}};
		List<List<Integer>> result = pacificAtlantic(matrix);
		
		for (List<Integer> list : result) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new LinkedList<>();
		}
		
		List<List<Integer>> result = new LinkedList<>();
		int m = matrix.length; // 세로
		int n = matrix[0].length; // 가로
		boolean[][] visitedPacific = new boolean[m][n];
		boolean[][] visitedAtlantic = new boolean[m][n];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int i = 0; i < m; i++) {
			if (!visitedPacific[i][0]) {
				visitedPacific[i][0] = true;
				recurrentPacificAtlantic(matrix, visitedPacific, dx, dy, i, 0);
			}
			
			
			if (!visitedAtlantic[i][n - 1]) {
				visitedAtlantic[i][n - 1] = true;
				recurrentPacificAtlantic(matrix, visitedAtlantic, dx, dy, i, n - 1);
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (!visitedPacific[0][i]) {
				visitedPacific[0][i] = true;
				recurrentPacificAtlantic(matrix, visitedPacific, dx, dy, 0, i);
			}
			
			if (!visitedAtlantic[m - 1][i]) {
				visitedAtlantic[m - 1][i] = true;
				recurrentPacificAtlantic(matrix, visitedAtlantic, dx, dy, m - 1, i);
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
					result.add(Arrays.asList(new Integer[]{i, j}));
				}
			}
		}
		
		return result;
	}
	
	public static void recurrentPacificAtlantic(int[][] matrix, boolean[][] visited, int[] dx, int[] dy, int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int currX = x + dx[i];
			int currY = y + dy[i];
			
			if (currX >= 0 && currX < matrix.length && currY >= 0 && currY < matrix[0].length && !visited[currX][currY] && matrix[currX][currY] >= matrix[x][y]) {
				visited[currX][currY] = true;
				
				recurrentPacificAtlantic(matrix, visited, dx, dy, currX, currY);
			}
		}
	}
}