package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class Count_Square_Submatrices_with_All_Ones {
	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 1, 1},
						{1, 1, 1, 1},
						{0, 1, 1, 1}};
		/*int[][] matrix = {{1, 0, 1},
						{1, 1, 0},
						{1, 1, 0}};*/
		
		System.out.println(countSquares(matrix));
	}
	
	public static int countSquares(int[][] matrix) {
		int result = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if ((i != 0 && j != 0) && matrix[i][j] != 0) {
					matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
				}
				
				result += matrix[i][j];
			}
		}
		
		return result;
	}
}