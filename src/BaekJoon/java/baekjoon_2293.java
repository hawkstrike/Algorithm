package BaekJoon.java;
// https://www.acmicpc.net/problem/2293

import java.util.Scanner;

public class baekjoon_2293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[k+1];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++)
				if(j - arr[i] >= 0)
					dp[j] += dp[j-arr[i]];
		}

		System.out.println(dp[k]);
		sc.close();
	}
}