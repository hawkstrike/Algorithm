package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/unique-paths-iii/
public class Unique_Paths_III {
	static int result = 0;
	
	public static void main(String[] args) {
		/*int[][] grid = {{1, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 2, -1}};*/
		int[][] grid = {{1, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 2}};
		
		System.out.println(uniquePathsIII(grid));
	}
	
	public static int uniquePathsIII(int[][] grid) {
		int paths = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					paths++;
				}
			}
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					recurrentUniquePathsIII(grid, i, j, paths);
					
					return result;
				}
			}
		}
		
		return result;
	}
	
	public static void recurrentUniquePathsIII(int[][] grid, int x, int y, int paths) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1 || (grid[x][y] == 2 && paths > 0)) {
			return;
		}
		
		if (grid[x][y] == 2 && paths == 0) {
			result++;
			
			return;
		}
		
		if (grid[x][y] == 0) {
			paths--;
		}
		
		grid[x][y] = -1;
		
		recurrentUniquePathsIII(grid, x - 1, y, paths);
		recurrentUniquePathsIII(grid, x, y + 1, paths);
		recurrentUniquePathsIII(grid, x + 1, y, paths);
		recurrentUniquePathsIII(grid, x, y - 1, paths);
		
		grid[x][y] = 0;
	}
}