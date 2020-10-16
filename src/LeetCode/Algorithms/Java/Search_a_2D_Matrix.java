package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/search-a-2d-matrix/
public class Search_a_2D_Matrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7},
						{10, 11, 16, 20},
						{23, 30, 34, 60}};
		int target = 13;
		
		System.out.println(searchMatrix(matrix, target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		for (int i = 0; i < matrix.length; i++) {
			int first = matrix[i][0];
			int last = matrix[i][matrix[i].length - 1];
			
			if (target >= first && target <= last) {
				return findTarget(matrix[i], target);
			}
		}
		
		return false;
	}
	
	public static boolean findTarget(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				left++;
			} else {
				right--;
			}
		}
		
		return false;
	}
}