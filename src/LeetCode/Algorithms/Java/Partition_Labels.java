package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
public class Partition_Labels {
	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
		List<Integer> result = partitionLabels(S);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> partitionLabels(String S) {
		int[] alphabetArr = new int[26];
		
		for (int i = 0; i < S.length(); i++) {
			alphabetArr[S.charAt(i) - 'a'] = i;
		}
		
		int max = 0;
		int anchor = 0;
		List<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < S.length(); i++) {
			max = Math.max(max, alphabetArr[S.charAt(i) - 'a']);
			
			if (i == max) {
				list.add(i - anchor + 1);
				anchor = i + 1;
			}
		}
		
		return list;
	}
}