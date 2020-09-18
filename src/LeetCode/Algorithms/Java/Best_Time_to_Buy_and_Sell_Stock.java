package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Best_Time_to_Buy_and_Sell_Stock {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		
		return maxProfit;
	}
}