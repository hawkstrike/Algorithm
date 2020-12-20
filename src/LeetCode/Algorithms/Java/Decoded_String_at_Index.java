package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/decoded-string-at-index/
public class Decoded_String_at_Index {
	public static void main(String[] args) {
		String S = "leet2code3";
		int K = 10;
		
		System.out.println(decodeAtIndex(S, K));
	}
	
	public static String decodeAtIndex(String S, int K) {
		int length = S.length();
		long size = 0;
		
		for (char c : S.toCharArray()) {
			if (Character.isDigit(c)) {
				size *= c - '0';
			} else {
				size++;
			}
		}
		
		for (int i = length - 1; i >= 0; i--) {
			char c = S.charAt(i);
			
			K %= size;
			
			if (K == 0 && Character.isLetter(c)) {
				return Character.toString(c);
			}
			
			if (Character.isDigit(c)) {
				size /= c - '0';
			} else {
				size--;
			}
		}
		
		return null;
	}
}