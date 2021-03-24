package LeetCode.Algorithms.Java;

import java.util.TreeMap;

// https://leetcode.com/problems/advantage-shuffle/
public class Advantage_Shuffle {
	public static void main(String[] args) {
		int[] A = {2, 7, 11, 15};
		int[] B = {1, 10, 4, 11};
		int[] result = advantageCount(A, B);
		
		for (int n : result) {
			System.out.println(n);
		}
	}
	
	public static int[] advantageCount(int[] A, int[] B) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		int length = A.length;
		int[] result = new int[length];
		
		for (int n : A) {
			treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
		}
		
		for (int i = 0; i < length; i++) {
			Integer x = treeMap.higherKey(B[i]);
			
			if (x == null) {
				x = treeMap.firstKey();
			}
			
			treeMap.put(x, treeMap.get(x) - 1);
			
			if (treeMap.get(x) == 0) {
				treeMap.remove(x);
			}
			
			result[i] = x;
		}
		
		return result;
	}
}