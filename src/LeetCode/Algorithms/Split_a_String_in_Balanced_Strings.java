package LeetCode.Algorithms;

// https://leetcode.com/problems/split-a-string-in-balanced-strings/
public class Split_a_String_in_Balanced_Strings {
	public static void main(String[] args){
		String s = "RLRRRLLRLL"; // "LLLLRRRR"; // "RLLLLRRRLR"; // "RLRRLLRLRL";

		System.out.println(balancedStringSplit(s));
	}
	
	public static int balancedStringSplit(String s) {
		int result = 0;
		int balanced = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'R') {
				balanced--;
			} else if (s.charAt(i) == 'L') {
				balanced++;
			}
			
			if (balanced == 0) {
				result++;
			}
		}
		
		return result;
	}
}