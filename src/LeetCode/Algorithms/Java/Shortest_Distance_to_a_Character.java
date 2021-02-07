package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/shortest-distance-to-a-character/
public class Shortest_Distance_to_a_Character {
	public static void main(String[] args) {
		/*String s = "loveleetcode";
		char c = 'e';*/
		String s = "aaab";
		char c = 'b';
		
		int[] result = shortestToChar(s, c);
		
		for (int ch : result) {
			System.out.print(ch + " ");
		}
		System.out.println();
	}
	
	public static int[] shortestToChar(String s, char c) {
		List<Integer> list = new LinkedList<>();
		int[] result = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				list.add(i);
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			int min = Integer.MAX_VALUE;
			
			for (int n : list) {
				min = Math.min(min, Math.abs(n - i));
			}
			
			result[i] = min;
		}
		
		return result;
	}
}