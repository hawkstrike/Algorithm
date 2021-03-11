package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/coin-change/
public class Coin_Change {
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		
		System.out.println(coinChange(coins, amount));
	}
	
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		int length = dp.length;
		
		for (int i = 1; i < length; i++) {
			dp[i] = length;
			
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		
		return (dp[amount] != length) ? dp[amount] : -1;
	}
}