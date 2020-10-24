package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/bag-of-tokens/
public class Bag_of_Tokens {
	public static void main(String[] args) {
		int[] tokens = {100};
		int P = 50;
		
		System.out.println(bagOfTokensScore(tokens, P));
	}
	
	public static int bagOfTokensScore(int[] tokens, int P) {
		int start = 0;
		int end = tokens.length - 1;
		int score = 0;
		
		Arrays.sort(tokens);
		
		while (start <= end) {
			if (P >= tokens[start]) {
				P -= tokens[start++];
				score++;
			} else if (score > 0 && P < tokens[start] && start != end) {
				P += tokens[end--];
				score--;
			} else {
				return score;
			}
		}
		
		return score;
	}
}