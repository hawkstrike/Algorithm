package LeetCode.Algorithms.Java;

import java.util.*;
import java.util.stream.IntStream;

// https://leetcode.com/problems/top-k-frequent-elements/
public class Top_K_Frequent_Elements {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		int[] result = topKFrequent(nums, k);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(nums[i])) {
				hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
			} else {
				hashMap.put(nums[i], 1);
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> hashMap.get(o1) - hashMap.get(o2)));
		
		for (int n : hashMap.keySet()) {
			pq.add(n);
			
			if (pq.size() > k) {
				pq.poll();
			}
		}
		
		int[] result = new int[k];
		
		for (int i = k - 1; i >= 0; i--) {
			result[i] = pq.poll();
		}
		
		return result;
	}
}