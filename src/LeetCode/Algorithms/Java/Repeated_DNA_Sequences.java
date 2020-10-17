package LeetCode.Algorithms.Java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/repeated-dna-sequences/
public class Repeated_DNA_Sequences {
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> result = findRepeatedDnaSequences(s);
		
		for (String str : result) {
			System.out.println(str);
		}
	}
	
	public static List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> repeatHashSet = new HashSet<>();
		HashSet<String> hashSet = new HashSet<>();
		
		for (int i = 0; i < s.length() - 9; i++) {
			String curr = s.substring(i, i + 10);
			
			if (hashSet.contains(curr)) {
				repeatHashSet.add(curr);
			} else {
				hashSet.add(curr);
			}
		}
		
		return new LinkedList<>(repeatHashSet);
	}
}