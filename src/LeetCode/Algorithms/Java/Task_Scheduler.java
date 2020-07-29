package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/task-scheduler/
public class Task_Scheduler {
	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int n = 2;
		
		System.out.println(leastInterval(tasks, n));
	}
	
	public static int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		int max = 0;
		int maxCount = 0;
		
		for (char c : tasks) {
			count[c - 'A']++;
			max = Math.max(count[c - 'A'], max);
		}
		
		for (int i : count) {
			if (i == max) {
				maxCount++;
			}
		}
		
		return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
	}
}