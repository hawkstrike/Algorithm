package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/consecutive-characters/
public class Consecutive_Characters {
	public static void main(String[] args) {
		String s = "leetcode";
		
		System.out.println(maxPower(s));
	}
	
	public static int maxPower(String s) {
		int result = 0;
		int count = 0;
		char c1 = ' ';
		
		for (int i = 0; i < s.length(); i++) {
			char c2 = s.charAt(i);
			
			if (c1 == c2) {
				count++;
			} else {
				count = 1;
				c1 = c2;
			}
			
			result = Math.max(result, count);
		}
		
		return result;
	}
}