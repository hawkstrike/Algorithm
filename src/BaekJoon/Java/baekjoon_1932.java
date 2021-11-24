package BaekJoon.Java;
// https://www.acmicpc.net/problem/1932

import java.util.Scanner;

public class baekjoon_1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] field = new int[n][n];
		int[][] dp = new int[n][n];
		int max = 0;

		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j <= i; j++)
				field[i][j] = sc.nextInt();
		}

		dp[0][0] = field[0][0];

		for(int i = 1; i < field.length; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					dp[i][j] = field[i][j] + dp[i-1][j];
				} else if(i == j){
					dp[i][j] = field[i][j] + dp[i-1][j-1];
				} else {
					dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + field[i][j];
				}
			}
		}

		for(int i = 0; i < dp.length; i++) {
			if(max < dp[dp.length-1][i])
				max = dp[dp.length-1][i];
		}

		System.out.println(max);
		sc.close();
	}

	public static int max(int x, int y) {
		return (x > y) ? x : y;
	}
}