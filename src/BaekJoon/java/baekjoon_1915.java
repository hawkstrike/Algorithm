package BaekJoon.java;
// https://www.acmicpc.net/problem/1915

import java.util.Scanner;

public class baekjoon_1915 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n+1][m+1];

		sc.nextLine();

		for(int i = 1; i <= n; i++) {
			String s = sc.nextLine();

			for(int j = 0; j < s.length(); j++)
				dp[i][j+1] = s.charAt(j) - 48;
		}

		int area = 0;

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(dp[i][j] != 0) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
					area = Math.max(area, dp[i][j]);
				}
			}
		}

		System.out.println(area * area);
		sc.close();
	}
}