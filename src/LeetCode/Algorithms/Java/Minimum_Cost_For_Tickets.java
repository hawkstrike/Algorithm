package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class Minimum_Cost_For_Tickets {
	public static void main(String[] args) {
		int[] days = {1, 4, 6, 7, 8, 20};
		int[] costs = {2, 7, 15};
		
		System.out.println(mincostTickets(days, costs));
	}
	
	public static int mincostTickets(int[] days, int[] costs) {
		int lastDay = days[days.length - 1];
		int[] dp = new int[lastDay + 1];
		int index = 0;
		
		for (int i = 1; i <= lastDay; i++) {
			if (i != days[index]) {
				dp[i] = dp[i - 1];
				
				continue;
			}
			
			index++;
			dp[i] = dp[i - 1] + costs[0];
			dp[i] = Math.min(dp[i], dp[(i >= 7 ? i - 7 : 0)] + costs[1]);
			dp[i] = Math.min(dp[i], dp[(i >= 30 ? i - 30 : 0)] + costs[2]);
		}
		
		return dp[lastDay];
	}
}