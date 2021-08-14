package Programmers.Practice.Level1;

// 행렬의 덧셈
// https://programmers.co.kr/learn/courses/30/lessons/12950
public class Problem_12950 {
	
	public static void main(String[] args) {
		int[][] arr1 = {{1, 2}, {2, 3}};
		int[][] arr2 = {{3}, {4}};
		int[][] result = solution(arr1, arr2);
		
		for (int[] arr : result) {
			for (int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int n = arr1.length;
		int m = arr2[0].length;
		int[][] result = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		return result;
	}
}