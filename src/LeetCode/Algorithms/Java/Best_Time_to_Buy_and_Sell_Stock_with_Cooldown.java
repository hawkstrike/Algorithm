package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 0, 2};
		
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int buy0 = -prices[0];
		int buy1 = buy0;
		int sell0 = 0;
		int sell1 = 0;
		int sell2 = 0;
		
		for (int i = 1; i < prices.length; i++) {
			buy0 = Math.max(buy1, sell2 - prices[i]);
			sell0 = Math.max(sell1, buy1 + prices[i]);
			buy1 = buy0;
			sell2 = sell1;
			sell1 = sell0;
		}
		
		return sell0;
	}
}