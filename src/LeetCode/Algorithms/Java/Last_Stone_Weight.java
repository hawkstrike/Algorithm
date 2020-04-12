package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/
public class Last_Stone_Weight {
	public static void main(String[] args){
		int[] stones = {2, 7, 4, 1, 8, 1};
		
		System.out.println(lastStoneWeight(stones));
	}
	
	public static int lastStoneWeight(int[] stones) {
		/*PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for (int stone : stones) {
			pq.offer(stone);
		}
		
		while (pq.size() > 1) {
			int x = pq.poll();
			int y = pq.poll();
			
			if (x != y) {
				pq.offer(x - y);
			}
		}
		
		return pq.isEmpty() ? 0 : pq.poll();*/
		
		if (stones.length > 1) {
			recurrentLastStoneWeight(stones);
		}
		
		return stones[stones.length - 1];
	}
	
	public static void recurrentLastStoneWeight(int[] stones) {
		Arrays.sort(stones);
		
		int length = stones.length;
		int x = stones[length - 2];
		int y = stones[length - 1];
		
		if (x == 0) {
			return;
		}
		
		if (x == y) {
			stones[length - 2] = 0;
			stones[length - 1] = 0;
		} else {
			stones[length - 2] = 0;
			stones[length - 1] -= x;
		}
		
		recurrentLastStoneWeight(stones);
	}
}