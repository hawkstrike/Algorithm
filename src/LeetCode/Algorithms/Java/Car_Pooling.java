package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/car-pooling/
public class Car_Pooling {
	public static void main(String[] args) {
		int[][] trips = {{2, 1, 5},
						{3, 3, 7}};
		int capacity = 4;
		
		System.out.println(carPooling(trips, capacity));
	}
	
	public static boolean carPooling(int[][] trips, int capacity) {
		int[] arr = new int[1001];
		
		for (int[] trip : trips) {
			arr[trip[1]] += trip[0];
			arr[trip[2]] -= trip[0];
		}
		
		int usedCapacity = 0;
		
		for (int n : arr) {
			usedCapacity += n;
			
			if (usedCapacity > capacity) {
				return false;
			}
		}
		
		return true;
	}
}