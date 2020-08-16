package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class Best_Time_to_Buy_and_Sell_Stock_III {
	public static void main(String[] args) {
		int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
		
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		int buy1 = Integer.MIN_VALUE;
		int buy2 = Integer.MIN_VALUE;
		int sell1 = 0;
		int sell2 = 0;
		
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		
		return sell2;
	}
}