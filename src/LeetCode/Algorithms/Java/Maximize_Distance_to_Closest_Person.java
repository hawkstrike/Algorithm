package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/maximize-distance-to-closest-person/
public class Maximize_Distance_to_Closest_Person {
	public static void main(String[] args) {
		int[] seats = {1, 0, 0, 0, 1, 0, 1};
		
		System.out.println(maxDistToClosest(seats));
	}
	
	public static int maxDistToClosest(int[] seats) {
		int N = seats.length;
		int prev = -1;
		int future = 0;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			if (seats[i] == 1) {
				prev = i;
			} else {
				while (future < N && seats[future] == 0 || future < i) {
					future++;
				}
				
				int left = (prev == -1) ? N : i - prev;
				int right = (future == N) ? N : future - i;
				
				result = Math.max(result, Math.min(left, right));
			}
		}
		
		return result;
	}
}