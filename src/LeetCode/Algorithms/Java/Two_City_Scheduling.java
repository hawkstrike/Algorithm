package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/two-city-scheduling/
public class Two_City_Scheduling {
	public static void main(String[] args) {
		/*int[][] costs = {{10, 20},
						{30, 200},
						{400, 50},
						{30, 20}};*/
		int[][] costs = {{259, 770},
						{448, 54},
						{926, 667},
						{184, 139},
						{840, 118},
						{577, 469}};
		
		System.out.println(twoCitySchedCost(costs));
	}
	
	public static int twoCitySchedCost(int[][] costs) {
		int result = 0;
		int N = costs.length / 2;
		int[] dp = new int[2 * N];
		
		for (int i = 0; i < 2 * N; i++) {
			result += costs[i][0];
			dp[i] = costs[i][1] - costs[i][0];
		}
		
		Arrays.sort(dp);
		
		for (int i = 0; i < N; i++) {
			result += dp[i];
		}
		
		return result;
	}
}