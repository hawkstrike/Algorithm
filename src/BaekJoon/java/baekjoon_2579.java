package BaekJoon.java;
// https://www.acmicpc.net/problem/2579

import java.util.Scanner;

public class baekjoon_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];

		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		dp[1] = arr[1];
		dp[2] = dp[1] + arr[2];
		
		for(int i = 3; i <= n; i++)
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i] + arr[i-1]);

		System.out.println(dp[n]);
		sc.close();
	}
}