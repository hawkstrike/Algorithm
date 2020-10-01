package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-recent-calls/
public class Number_of_Recent_Calls {
	public static class RecentCounter {
		/*LinkedList<Integer> list = null;
		int[] range = null;*/
		Queue<Integer> q;
		
		public RecentCounter() {
			/*this.list = new LinkedList<>();
			this.range = new int[2];*/
			this.q = new LinkedList<>();
		}
		
		public int ping(int t) {
			/*int count = 0;
			
			this.list.add(t);
			this.range[0] = t - 3000;
			this.range[1] = t;
			
			for (int n : this.list) {
				if (this.range[0] <= n && this.range[1] >= n) {
					count++;
				}
			}
			
			return count;*/
			int range = t - 3000;
			this.q.offer(t);
			
			while (this.q.peek() < range) {
				this.q.remove();
			}
			
			return this.q.size();
		}
	}
	
	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();
		
		System.out.println(recentCounter.ping(1));
		System.out.println(recentCounter.ping(100));
		System.out.println(recentCounter.ping(3001));
		System.out.println(recentCounter.ping(3002));
	}
}