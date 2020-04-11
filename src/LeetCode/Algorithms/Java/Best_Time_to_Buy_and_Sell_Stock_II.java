package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Best_Time_to_Buy_and_Sell_Stock_II {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		int result = 0;
		
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				result += prices[i] - prices[i - 1];
			}
		}
		
		return result;
	}
}