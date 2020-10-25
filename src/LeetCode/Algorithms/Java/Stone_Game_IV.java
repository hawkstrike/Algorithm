package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/stone-game-iv/
public class Stone_Game_IV {
	public static void main(String[] args) {
		int n = 1;
		
		System.out.println(winnerSquareGame(n));
	}
	
	public static boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
		
		for (int i = 0; i <= n; i++) {
			if (dp[i]) {
				continue;
			}
			
			for (int j = 1; i + j * j <= n; j++) {
				dp[i + j * j] = true;
			}
		}
		
		return dp[n];
	}
}