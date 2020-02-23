package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
public class Count_Negative_Numbers_in_a_Sorted_Matrix {
	public static void main(String[] args){
		int[][] grid = {{4, 3, 2, -1},
						{3, 2, 1, -1},
						{1, 1, -1, -2},
						{-1, -1, -2, -3}};

		System.out.println(countNegatives(grid));
	}
	
	public static int countNegatives(int[][] grid) {
		int result = 0;
		
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][grid[i].length - 1] >= 0) {
				continue;
			}
			
			for (int j = grid[i].length - 1; j >= 0; j--) {
				if (grid[i][j] < 0) {
					result++;
				} else {
					break;
				}
			}
		}
		
		return result;
	}
}