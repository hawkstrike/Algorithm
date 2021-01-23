package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/sort-the-matrix-diagonally/
public class Sort_the_Matrix_Diagonally {
	public static void main(String[] args) {
		int[][] mat = {{3, 3, 1, 1},
					{2, 2, 1, 2,},
					{1, 1, 1, 2}};
		int[][] result = diagonalSort(mat);
		
		for (int[] arr : result) {
			for (int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] diagonalSort(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				int row = i + 1;
				int col = j + 1;
				
				while (row < mat.length && col < mat[0].length) {
					if (mat[i][j] > mat[row][col]) {
						int temp = mat[i][j];
						
						mat[i][j] = mat[row][col];
						mat[row][col] = temp;
					}
					
					row++;
					col++;
				}
			}
		}
		
		return mat;
	}
}