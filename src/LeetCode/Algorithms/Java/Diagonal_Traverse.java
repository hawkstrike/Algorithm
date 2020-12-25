package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/diagonal-traverse/
public class Diagonal_Traverse {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3},
							{4, 5, 6},
							{7, 8, 9}};
		int[] result = findDiagonalOrder(matrix);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();;
	}
	
	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new int[0];
		}
		
		int N = matrix.length;
		int M = matrix[0].length;
		int row = 0;
		int col = 0;
		int direction = 1;
		int[] result = new int[N * M];
		int r = 0;
		
		while (row < N && col < M) {
			result[r++] = matrix[row][col];
			
			int nextRow = row + (direction == 1 ? -1 : 1);
			int nextCol = col + (direction == 1 ? 1 : -1);
			
			if (nextRow < 0 || nextRow == N || nextCol < 0 || nextCol == M) {
				if (direction == 1) {
					row += (col == M - 1) ? 1 : 0;
					col += (col < M - 1) ? 1 : 0;
				} else {
					col += (row == N - 1) ? 1 : 0;
					row += (row < N - 1) ? 1 : 0;
				}
				
				direction = 1 - direction;
			} else {
				row = nextRow;
				col = nextCol;
			}
		}
		
		return result;
	}
}