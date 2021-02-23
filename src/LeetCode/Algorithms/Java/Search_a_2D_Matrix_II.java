package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class Search_a_2D_Matrix_II {
	public static void main(String[] args) {
		int[][] matrix = {{1, 4, 7, 11, 15},
						{2, 5, 8, 12, 19},
						{3, 6, 9, 16, 22},
						{10, 13, 14, 17, 24},
						{18, 21, 23, 26, 30}};
		int target = 20;
		
		System.out.println(searchMatrix(matrix, target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int[] arr : matrix) {
			int left = 0;
			int right = arr.length - 1;
			
			for (int i = 0; i < arr.length; i++) {
				while (left < right) {
					int mid = left + (right - left) / 2;
					
					if (arr[mid] == target) {
						return true;
					} else if (arr[mid] < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		
		return false;
	}
}