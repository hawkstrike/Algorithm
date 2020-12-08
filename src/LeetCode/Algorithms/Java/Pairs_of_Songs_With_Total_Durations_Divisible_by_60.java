package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
	public static void main(String[] args) {
		//int[] time = {30, 20, 150, 100, 40};
		int[] time = {60, 60, 60};
		
		System.out.println(numPairsDivisibleBy60(time));
	}
	
	public static int numPairsDivisibleBy60(int[] time) {
		int[] remainders = new int[60];
		int result = 0;
		
		for (int t : time) {
			if (t % 60 == 0) {
				result += remainders[0];
			} else {
				result += remainders[60 - t % 60];
			}
			
			remainders[t % 60]++;
		}
		
		return result;
		
		/*int result = 0;
		
		for (int i = 0; i < time.length; i++) {
			for (int j = i + 1; j < time.length; j++) {
				if ((time[i] + time[j]) % 60 == 0) {
					result++;
				}
			}
		}
		
		return result;*/
	}
}