package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/teemo-attacking/
public class Teemo_Attacking {
	public static void main(String[] args) {
		int[] timeSeries = {1, 4};
		int duration = 2;
		
		System.out.println(findPoisonedDuration(timeSeries, duration));
	}
	
	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		int n = timeSeries.length;
		int result = 0;
		
		if (n == 0) {
			return 0;
		}
		
		for (int i = 0; i < n - 1; i++) {
			result += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
		}
		
		return result + duration;
	}
}