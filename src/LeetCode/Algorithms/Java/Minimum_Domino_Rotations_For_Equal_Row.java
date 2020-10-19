package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
public class Minimum_Domino_Rotations_For_Equal_Row {
	public static void main(String[] args) {
		int[] A = {2, 1, 2, 4, 2, 2};
		int[] B = {5, 2, 6, 2, 3, 2};
		
		System.out.println(minDominoRotations(A, B));
	}
	
	public static int minDominoRotations(int[] A, int[] B) {
		int result = Math.min(swap(A, B, A[0]), swap(B, A, B[0]));
		
		return (result == Integer.MAX_VALUE) ? -1 : result;
	}
	
	public static int swap(int[] A, int[] B, int target) {
		int aSwap = 0;
		int bSwap = 0;
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] != target && B[i] != target) {
				return Integer.MAX_VALUE;
			}
			
			if (A[i] != target) {
				bSwap++;
			}
			
			if (B[i] != target) {
				aSwap++;
			}
		}
		
		return Math.min(aSwap, bSwap);
	}
}