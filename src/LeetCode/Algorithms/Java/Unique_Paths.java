package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/unique-paths/
public class Unique_Paths {
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		
		System.out.println(uniquePaths(m, n));
	}
	
	public static int uniquePaths(int m, int n) {
		/*int x = m + n - 2;
		int y = Math.min(m, n) - 1;
		long result = 1;
		
		for (int i = 1; i <= y; i++) {
			result *= (x - i + 1);
			result /= i;
		}
		
		return (int) result;*/
		
		int[][] dp = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 || j == 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		
		return dp[m][n];
	}
}