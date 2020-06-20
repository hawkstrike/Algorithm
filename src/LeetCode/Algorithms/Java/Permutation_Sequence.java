package LeetCode.Algorithms.Java;

import java.util.LinkedList;

// https://leetcode.com/problems/permutation-sequence/
public class Permutation_Sequence {
	public static void main(String[] args) {
		int n = 3;
		int k = 3;
		
		System.out.println(getPermutation(n, k));
	}
	
	public static String getPermutation(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		int[] factorial = new int[n];
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		factorial[0] = 1;
		
		for (int i = 1; i < n; i++) {
			factorial[i] = i * factorial[i - 1];
		}
		
		k--;
		
		for (int i = n; i > 0; i--) {
			int indicate = k / factorial[i - 1];
			
			k = k % factorial[i - 1];
			sb.append(list.get(indicate));
			list.remove(indicate);
		}
		
		return sb.toString();
	}
}