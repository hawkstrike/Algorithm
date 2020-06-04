package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/reverse-string/
public class Reverse_String {
	public static void main(String[] args) {
		char[] s = {'h', 'e', 'l', 'l', 'o'};
		
		reverseString(s);
	}
	
	public static void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		
		while (left <= right) {
			int c = s[left];
			
			s[left++] = s[right];
			s[right--] = (char) c;
		}
	}
}