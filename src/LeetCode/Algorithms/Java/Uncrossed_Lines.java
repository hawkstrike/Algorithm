package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/uncrossed-lines/
public class Uncrossed_Lines {
	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {1, 2, 4};
		/*int[] A = {2, 5, 1, 2, 5};
		int[] B = {10, 5, 2, 1, 5, 2};*/
		
		System.out.println(maxUncrossedLines(A, B));
	}
	
	public static int maxUncrossedLines(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = (A[i - 1] == B[j - 1]) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		return dp[dp.length - 1][dp[0].length - 1];
	}
}