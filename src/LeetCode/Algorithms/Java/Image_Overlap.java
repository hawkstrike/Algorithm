package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/image-overlap/
public class Image_Overlap {
	public static void main(String[] args) {
		int[][] A = {{1, 1, 0},
					{0, 1, 0},
					{0, 1, 0}};
		int[][] B = {{0, 0, 0},
					{0, 1, 1},
					{0, 0, 1}};
		
		System.out.println(largestOverlap(A, B));
	}
	
	public static int largestOverlap(int[][] A, int[][] B) {
		int result = 0;
		
		for (int yShift = 0; yShift < A.length; yShift++) {
			for (int xShift = 0; xShift < A.length; xShift++) {
				result = Math.max(result, shiftAndCount(xShift, yShift, A, B));
				result = Math.max(result, shiftAndCount(xShift, yShift, B, A));
			}
		}
		
		return result;
	}
	
	public static int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
		int count = 0;
		int rRow = 0;
		
		for (int mRow = yShift; mRow < M.length; mRow++) {
			int rCol = 0;
			
			for (int mCol = xShift; mCol < M.length; mCol++) {
				if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol]) {
					count++;
				}
				
				rCol++;
			}
			
			rRow++;
		}
		
		return count;
	}
}