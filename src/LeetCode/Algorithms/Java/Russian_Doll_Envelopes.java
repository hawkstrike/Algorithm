package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.TreeSet;

// https://leetcode.com/problems/russian-doll-envelopes/
public class Russian_Doll_Envelopes {
	public static void main(String[] args) {
		int[][] envelopes = {{5, 4},
							{6, 4},
							{6, 7},
							{2, 3}};
		
		System.out.println(maxEnvelopes(envelopes));
	}
	
	public static int maxEnvelopes(int[][] envelopes) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		Arrays.sort(envelopes, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
		
		for (int[] arr : envelopes) {
			Integer ceiling = treeSet.ceiling(arr[1]);
			
			if (ceiling != null && ceiling.intValue() != arr[1]) {
				treeSet.remove(ceiling);
			}
			
			treeSet.add(arr[1]);
		}
		
		return treeSet.size();
	}
}