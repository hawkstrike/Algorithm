package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/champagne-tower/
public class Champagne_Tower {
	public static void main(String[] args) {
		int poured = 1;
		int query_row = 1;
		int query_glass = 1;
		
		System.out.println(champagneTower(poured, query_row, query_glass));
	}
	
	public static double champagneTower(int poured, int query_row, int query_glass) {
		double[][] A = new double[100][100];
		
		A[0][0] = poured;
		
		for (int row = 0; row < query_row; row++) {
			for (int col = 0; col <= row; col++) {
				double q = (A[row][col] - 1.0) / 2.0;
				
				if (q > 0) {
					A[row + 1][col] += q;
					A[row + 1][col + 1] += q;
				}
			}
		}
		
		return Math.min(1, A[query_row][query_glass]);
	}
}