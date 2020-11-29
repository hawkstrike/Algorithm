package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/jump-game-iii/
public class Jump_Game_III {
	public static void main(String[] args) {
		/*int[] arr = {4, 2, 3, 0, 3, 1, 2};
		int start = 5;*/
		/*int[] arr = {4, 2, 3, 0, 3, 1, 2};
		int start = 0;*/
		/*int[] arr = {3, 0, 2, 1, 2};
		int start = 2;*/
		int[] arr = {0, 1};
		int start = 1;
		
		System.out.println(canReach(arr, start));
	}
	
	public static boolean canReach(int[] arr, int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[arr.length];
		
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int left = curr - arr[curr];
			int right = curr + arr[curr];
			
			if (arr[curr] == 0) {
				return true;
			}
			
			if (left >= 0 && !visited[left]) {
				queue.offer(left);
				visited[left] = true;
			}
			
			if (right < arr.length && !visited[right]) {
				queue.offer(right);
				visited[right] = true;
			}
		}
		
		return false;
	}
}