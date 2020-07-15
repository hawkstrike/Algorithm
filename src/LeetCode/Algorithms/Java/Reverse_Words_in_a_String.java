package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class Reverse_Words_in_a_String {
	public static void main(String[] args) {
		//String s = "the sky is blue";
		//String s = "  hello world!  ";
		String s = "a good   example";
		
		System.out.println("'" + reverseWords(s) + "'");
	}
	
	public static String reverseWords(String s) {
		StringBuffer sb = new StringBuffer();
		String[] strArr = s.trim().split("\\s+");
		
		for (int i = strArr.length - 1; i >= 0; i--) {
			sb.append(strArr[i]).append(" ");
		}
		
		return sb.toString().trim();
	}
}