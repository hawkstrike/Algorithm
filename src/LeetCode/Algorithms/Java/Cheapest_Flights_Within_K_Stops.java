package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class Cheapest_Flights_Within_K_Stops {
	public static class flight {
		int src;
		int dst;
		int price;
		
		public flight(int src, int dst, int price) {
			this.src = src;
			this.dst = dst;
			this.price = price;
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] edges = {{0, 1, 100},
					{1, 2, 100},
					{0, 2, 500}};
		int src = 0;
		int dst = 2;
		int K = 1;
		
		System.out.println(findCheapestPrice(n, edges, src, dst, K));
	}
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		ArrayList<int[]>[] graphList = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			graphList[i] = new ArrayList<>();
		}
		
		for (int[] flight : flights) {
			graphList[flight[0]].add(new int[]{flight[1], flight[2]});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		pq.offer(new int[]{src, K + 1, 0});
		
		while (!pq.isEmpty()) {
			int[] currFlight = pq.poll();
			
			if (currFlight[0] == dst) {
				return currFlight[2];
			}
			
			if (currFlight[1] > 0) {
				for (int[] next : graphList[currFlight[0]]) {
					pq.offer(new int[]{next[0], currFlight[1] - 1, currFlight[2] + next[1]});
				}
			}
		}
		
		return -1;
	}
}