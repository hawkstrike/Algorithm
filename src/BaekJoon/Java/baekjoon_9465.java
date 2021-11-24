package BaekJoon.Java;
// https://www.acmicpc.net/problem/9465

import java.util.Scanner;

public class baekjoon_9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[2][n+1];
			int[][] dp = new int[n+1][3];

			for(int j = 0; j < 2; j++) {
				for(int k = 1; k <= n; k++)
					arr[j][k] = sc.nextInt();
			}

			for(int j = 1; j <= n; j++) {
				dp[j][0] = Math.max(dp[j-1][0], Math.max(dp[j-1][1], dp[j-1][2]));
				dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2]) + arr[0][j];
				dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1]) + arr[1][j];
			}

			System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
		}

		sc.close();
	}
}