package LeetCode.Algorithms.Java;


import java.util.HashSet;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class Insert_Delete_GetRandom_O_1 {
	public static class RandomizedSet {
		HashSet<Integer> hashSet = null;
		
		/** Initialize your data structure here. */
		public RandomizedSet() {
			hashSet = new HashSet<>();
		}
		
		/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
		public boolean insert(int val) {
			if (hashSet.contains(val)) {
				return false;
			}
			
			hashSet.add(val);
			
			return true;
		}
		
		/** Removes a value from the set. Returns true if the set contained the specified element. */
		public boolean remove(int val) {
			if (!hashSet.contains(val)) {
				return false;
			}
			
			hashSet.remove(val);
			
			return true;
		}
		
		/** Get a random element from the set. */
		public int getRandom() {
			return (int) hashSet.toArray()[new Random().nextInt(hashSet.size())];
		}
	}
	public static void main(String[] args) {
	
	}
}