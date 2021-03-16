package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
	public static void main(String[] args) {
		/*int[] prices = {1, 3, 2, 8, 4, 9};
		int fee = 2;*/
		int[] prices = {1, 3, 7, 5, 10, 3};
		int fee = 3;
		
		System.out.println(maxProfit(prices, fee));
	}
	
	public static int maxProfit(int[] prices, int fee) {
		int cash = 0;
		int hold = -prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			cash = Math.max(cash, hold + prices[i] - fee);
			hold = Math.max(hold, cash - prices[i]);
		}
		
		return cash;
	}
}