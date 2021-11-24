package BaekJoon.Java;
// https://www.acmicpc.net/problem/11722

import java.util.Scanner;

public class baekjoon_11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		int max = 0;

		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;

			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}

			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
		sc.close();
	}
}