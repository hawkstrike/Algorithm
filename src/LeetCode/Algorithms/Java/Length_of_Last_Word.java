package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/length-of-last-word/
public class Length_of_Last_Word {
	public static void main(String[] args) {
		String s = "Hello                World            ";
		
		System.out.println(lengthOfLastWord(s));
	}
	
	public static int lengthOfLastWord(String s) {
		String[] arr = s.trim().split("\\s+");
		
		return arr[arr.length - 1].length();
	}
}