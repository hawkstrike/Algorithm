package BaekJoon.Java;
// https://www.acmicpc.net/problem/2225

import java.util.Scanner;

public class baekjoon_2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[][] dp = new long[k+1][n+1];

		dp[0][0] = 1;
		for(int i = 1; i <= k; i++) {
			for(int j = 0; j <= n; j++)
				for(int l = 0; l <= j; l++)
					dp[i][j] = (dp[i][j] + dp[i-1][j-l]) % 1000000000;
		}

		System.out.println(dp[k][n]);
		sc.close();
	}
}