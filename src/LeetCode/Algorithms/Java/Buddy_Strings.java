package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/buddy-strings/
public class Buddy_Strings {
	public static void main(String[] args) {
		String A = "ab";
		String B = "ba";
		
		System.out.println(buddyStrings(A, B));
	}
	
	public static boolean buddyStrings(String A, String B) {
		if (A.length() != B.length()) {
			return false;
		}
		
		if (A.equals(B)) {
			int[] alphabetArr = new int[26];
			
			for (int i = 0; i < A.length(); i++) {
				alphabetArr[A.charAt(i) - 'a']++;
			}
			
			for (int c : alphabetArr) {
				if (c > 1) {
					return true;
				}
			}
			
			return false;
		} else {
			int first = -1;
			int second = -1;
			
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i)) {
					if (first == -1) {
						first = i;
					} else if (second == -1) {
						second = i;
					} else {
						return false;
					}
				}
			}
			
			return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
		}
	}
}