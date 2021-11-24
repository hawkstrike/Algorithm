package BaekJoon.Java;
// https://www.acmicpc.net/problem/9461

import java.util.Scanner;

public class baekjoon_9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[101];

		dp[1] = dp[2] = 1;

		for(int i = 3; i < 101; i++)
			dp[i] = dp[i-2] + dp[i-3];

		for(int i = 0; i < T; i++)
			System.out.println(dp[sc.nextInt()]);

		sc.close();
	}
}