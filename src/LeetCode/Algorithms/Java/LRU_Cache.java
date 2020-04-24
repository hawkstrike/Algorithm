package LeetCode.Algorithms.Java;

import java.util.LinkedHashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
public class LRU_Cache {
	public static class LRUCache {
		LinkedHashMap<Integer, Integer> linkedHashMap = null;
		
		public LRUCache(int capacity) {
			linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
				@Override
				protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
					return size() > capacity;
				}
			};
		}
		
		public int get(int key) {
			return linkedHashMap.getOrDefault(key, -1);
		}
		
		public void put(int key, int value) {
			linkedHashMap.put(key, value);
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}
}