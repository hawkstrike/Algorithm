package BaekJoon.Java;
// https://www.acmicpc.net/problem/11057

import java.util.Scanner;

public class baekjoon_11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[1001][10];

		for(int i = 0; i <= 9; i++)
			dp[1][i] = 1;

		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++)
				for(int k = 9; k >= j; k--)
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
		}

		long sum = 0;

		for(int i = 0; i <= 9; i++)
			sum = (sum + dp[n][i]) % 10007;

		System.out.println(sum);
		sc.close();
	}
}