package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class Best_Time_to_Buy_and_Sell_Stock_IV {
	public static void main(String[] args) {
		int k = 2;
		int[] prices = {2, 4, 1};
		
		System.out.println(maxProfit(k, prices));
	}
	
	public static int maxProfit(int k, int[] prices) {
		int length = prices.length;
		
		if (length <= 1) {
			return 0;
		}
		
		if (k >= length / 2) {
			int profit = 0;
			
			for (int i = 1; i < length; i++) {
				if (prices[i] > prices[i - 1]) {
					profit += prices[i] - prices[i - 1];
				}
			}
			
			return profit;
		}
		
		int[][] dp = new int[k + 1][length];
		
		for (int i = 1; i <= k; i++) {
			int max = dp[i - 1][0] - prices[0];
			
			for (int j = 1; j < length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
				max = Math.max(max, dp[i - 1][j] - prices[j]);
			}
		}
		
		return dp[k][length - 1];
	}
}