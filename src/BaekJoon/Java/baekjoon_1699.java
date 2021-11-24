package BaekJoon.Java;
// https://www.acmicpc.net/problem/1699

import java.util.Scanner;

public class baekjoon_1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[100001];

		dp[1] = 1;

		for(int i = 1; i <= n; i++) {
			dp[i] = i;
			for(int j = 1; j * j <= i; j++)
				if(dp[i] > dp[i - j * j] + 1) {
					dp[i] = dp[i - j * j] + 1;
				}
		}

		System.out.println(dp[n]);
		sc.close();
	}
}