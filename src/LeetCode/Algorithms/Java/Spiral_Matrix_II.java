package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/spiral-matrix-ii/
public class Spiral_Matrix_II {
	public static void main(String[] args) {
		int n = 5;
		int[][] result = generateMatrix(n);
		
		for (int[] arr : result) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int index = 1;
		int i = 0;
		int j = 0;
		int direction = 0;
		
		while (index <= n * n) {
			matrix[i][j] = index;
			
			int row = Math.floorMod(i + dx[direction], n);
			int col = Math.floorMod(j + dy[direction], n);
			
			if (matrix[row][col] != 0) {
				direction = (direction + 1) % 4;
			}
			
			i += dx[direction];
			j += dy[direction];
			
			index++;
		}
		
		return matrix;
	}
}