package BaekJoon.java;
// https://www.acmicpc.net/problem/5557

import java.util.Scanner;

public class baekjoon_5557 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n-1][21];

		dp[0][sc.nextInt()] = 1;

		for(int i = 1; i < n - 1; i++) {
			int index = sc.nextInt();

			for(int j = 0; j < 21; j++) {
				if(dp[i-1][j] > 0) {
					if(j - index >= 0)
						dp[i][j-index] += dp[i-1][j];
					if(j + index < 21)
						dp[i][j+index] += dp[i-1][j];
				}
			}
		}

		System.out.println(dp[n-2][sc.nextInt()]);
		sc.close();
	}
}