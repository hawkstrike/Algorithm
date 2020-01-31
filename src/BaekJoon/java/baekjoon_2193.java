package BaekJoon.java;
// https://www.acmicpc.net/problem/2193

import java.util.Scanner;

public class baekjoon_2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[91];

		dp[1]= 1;
		for(int i = 2; i < 91; i++)
			dp[i] = dp[i-2] + dp[i-1];

		System.out.println(dp[n]);
		sc.close();
	}
}