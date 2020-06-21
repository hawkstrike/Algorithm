package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/dungeon-game/
public class Dungeon_Game {
	public static void main(String[] args) {
		int[][] dungeon = {{-2, -3, 3},
							{-5, -10, 1},
							{10, 30, -5}};
		
		System.out.println(calculateMinimumHP(dungeon));
	}
	
	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		dp[m][n - 1] = 1;
		dp[m - 1][n] = 1;
		
		for (int i = m - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--) {
				int min = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
				
				dp[i][j] = min < 1 ? 1 : min;
			}
		
		return dp[0][0];
	}
}