package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/maximal-square/
public class Maximal_Square {
	public static void main(String[] args) {
		char[][] matrix = {{'1', '0', '1', '0', '0'},
							{'1', '0', '1', '1', '1'},
							{'1', '1', '1', '1', '1'},
							{'1', '0', '1', '1', '1'}};
		
		System.out.println(maximalSquare(matrix));
	}
	
	public static int maximalSquare(char[][] matrix) {
		int row = matrix.length + 1;
		int col = matrix.length > 0 ? matrix[0].length + 1 : 0;
		int[][] dp = new int[row][col];
		int result = 0;
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		
		return result * result;
	}
}