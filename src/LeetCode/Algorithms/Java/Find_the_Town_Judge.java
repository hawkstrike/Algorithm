package LeetCode.Algorithms.Java;

import java.util.Hashtable;

// https://leetcode.com/problems/find-the-town-judge/
public class Find_the_Town_Judge {
	public static void main(String[] args) {
		int N = 2;
		int[][] trust = {{1, 2}};
		/*int[][] trust = {{1, 3},
						{2, 3}};*/
		/*int[][] trust = {{1, 2},
						{2, 3}, {3, 1}};*/
		/*int[][] trust = {{1, 3},
						{1, 4},
						{2, 3},
						{2, 4},
						{4, 3}};*/
		
		System.out.println(findJudge(N, trust));
	}
	
	public static int findJudge(int N, int[][] trust) {
		int[] judge = new int[N + 1];
		
		for (int i = 0; i < trust.length; i++) {
			judge[trust[i][0]]--;
			judge[trust[i][1]]++;
		}
		
		for (int i = judge.length - 1; i > 0; i--) {
			if (judge[i] == N - 1) {
				return i;
			}
		}
		
		return -1;
	}
}