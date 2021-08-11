package Programmers.Practice.Level2;

// 행렬의 곱셈
// https://programmers.co.kr/learn/courses/30/lessons/12949
public class Problem_12949 {
	
	public static void main(String[] args) {
		int[][] arr1 = {{1, 4},
						{3, 2},
						{4, 1}};
		int[][] arr2 = {{3, 3},
						{3, 3}};
		int[][] result = solution(arr1, arr2);
		
		for (int[] arr : result) {
			System.out.println(arr[0] + " | " + arr[1]);
		}
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int n = arr1.length;
		int m = arr2[0].length;
		int l = arr1[0].length;
		int[][] result = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < l; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		return result;
	}
}