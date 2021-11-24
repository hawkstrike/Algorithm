package BaekJoon.Java;
// https://www.acmicpc.net/problem/2133

import java.util.Scanner;

public class baekjoon_2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[31];

		dp[0] = 1;
		dp[2] = 3;

		for(int i = 4; i <= 30; i += 2) {
			dp[i] = 3 * dp[i-2];

			for(int j = 4; j <= i; j += 2)
				dp[i] += 2 * dp[i-j];
		}

		System.out.println(dp[n]);
		sc.close();
	}
}