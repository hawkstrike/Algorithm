package LeetCode.Algorithms.Java;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimize-deviation-in-array/
public class Minimize_Deviation_in_Array {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		
		System.out.println(minimumDeviation(nums));
	}
	
	public static int minimumDeviation(int[] nums) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		int min = Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		
		for (int n : nums) {
			if (n % 2 == 1) {
				n *= 2;
			}
			
			priorityQueue.offer(-n);
			min = Math.min(min, n);
		}
		
		while (true) {
			int n = -priorityQueue.poll();
			
			result = Math.min(result, n - min);
			
			if (n % 2 == 1) {
				break;
			}
			
			min = Math.min(min, n / 2);
			priorityQueue.add(-n / 2);
		}
		
		return result;
	}
}