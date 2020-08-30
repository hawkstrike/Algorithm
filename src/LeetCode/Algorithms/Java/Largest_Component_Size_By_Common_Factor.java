package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/largest-component-size-by-common-factor/
public class Largest_Component_Size_By_Common_Factor {
	public static void main(String[] args) {
		int[] A = {4, 6, 15, 35};
		
		System.out.println(largestComponentSize(A));
	}
	
	public static int largestComponentSize(int[] A) {
		int max = 0;
		
		for (int n : A) {
			max = Math.max(n, max);
		}
		
		int[] parent = new int[max + 1];
		
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		for (int n : A) {
			for (int i = (int) Math.sqrt(n); i >= 2; i--) {
				if (n % i == 0) {
					union(parent, n, i);
					union(parent, n, n / i);
				}
			}
		}
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int result = 0;
		
		for (int n : A) {
			int i = find(parent, n);
			
			if (!hashMap.containsKey(i)) {
				hashMap.put(i, 1);
			} else {
				hashMap.put(i, hashMap.get(i) + 1);
				
				result = Math.max(result, hashMap.get(i));
			}
		}
		
		return result;
	}
	
	public static int find(int[] parent, int x) {
		return (parent[x] == x) ? x : (parent[x] = find(parent, parent[x]));
	}
	
	public static void union(int[] parent, int x, int y) {
		parent[find(parent, x)] = parent[find(parent, y)];
	}
}