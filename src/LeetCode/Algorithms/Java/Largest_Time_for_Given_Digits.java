package LeetCode.Algorithms.Java;

import java.util.LinkedList;

// https://leetcode.com/problems/largest-time-for-given-digits/
public class Largest_Time_for_Given_Digits {
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		
		System.out.println(largestTimeFromDigits(A));
	}
	
	public static String largestTimeFromDigits(int[] A) {
		LinkedList<String> list = new LinkedList<>();
		
		list.add("");
		
		for (int n : A) {
			for (int size = list.size(); size > 0; size--) {
				String str = list.poll();
				
				for (int i = 0; i <= str.length(); i++) {
					list.add(str.substring(0, i) + n + str.substring(i));
				}
			}
		}
		
		String result = "";
		
		for (String s : list) {
			s = s.substring(0, 2) + ":" + s.substring(2);
			
			if (s.charAt(3) < '6' && s.compareTo("24:00") < 0 && s.compareTo(result) > 0) {
				result = s;
			}
		}
		
		return result;
	}
}