package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/score-of-parentheses/
public class Score_of_Parentheses {
	public static void main(String[] args) {
		String S = "()";
		
		System.out.println(scoreOfParentheses(S));
	}
	
	public static int scoreOfParentheses(String S) {
		int result = 0;
		int balance = 0;
		
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				balance++;
			} else {
				balance--;
				
				if (S.charAt(i - 1) == '(') {
					result += 1 << balance;
				}
			}
		}
		
		return result;
	}
}