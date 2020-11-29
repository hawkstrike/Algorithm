package LeetCode.Algorithms.Java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/sliding-window-maximum/
public class Sliding_Window_Maximum {
	public static void main(String[] args) {
		/*int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;*/
		/*int[] nums = {1};
		int k = 1;*/
		/*int[] nums = {1, -1};
		int k = 1;*/
		/*int[] nums = {9, 11};
		int k = 2;*/
		int[] nums = {4, -2};
		int k = 2;
		
		int[] result = maxSlidingWindow(nums, k);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deque = new ArrayDeque<>();
		List<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
				deque.removeLast();
			}
			
			deque.offerLast(i);
			
			if (deque.getFirst() == i - k) {
				deque.removeFirst();
			}
			
			if (i >= k - 1) {
				list.add(nums[deque.peek()]);
			}
		}
		
		return list.stream().mapToInt(n -> n).toArray();
	}
}