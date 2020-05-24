package LeetCode.Algorithms.Java;

import java.util.ArrayList;

// https://leetcode.com/problems/interval-list-intersections/
public class Interval_List_Intersections {
	public static void main(String[] args) {
		int[][] A = {{0, 2},
					{5, 10},
					{13, 23},
					{24, 25}};
		int[][] B = {{1, 5},
					{8, 12},
					{15, 24},
					{25, 26}};
		
		int[][] result = intervalIntersection(A, B);
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		ArrayList<int[]> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		
		while (i < A.length && j < B.length) {
			int left = Math.max(A[i][0], B[j][0]);
			int right = Math.min(A[i][1], B[j][1]);
			
			if (left <= right) {
				list.add(new int[]{left, right});
			}
			
			if (A[i][1] < B[j][1]) {
				i++;
			} else if (A[i][1] > B[j][1]) {
				j++;
			} else {
				i++;
				j++;
			}
		}
		
		return list.toArray(new int[list.size()][]);
	}
}