package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/detect-capital/
public class Detect_Capital {
	public static void main(String[] args) {
		//String word = "USA";
		//String word = "Google";
		String word = "g";
		
		System.out.println(detectCapitalUse(word));
	}
	
	public static boolean detectCapitalUse(String word) {
		return word.matches("[A-Z]*|.[a-z]*");
	}
}