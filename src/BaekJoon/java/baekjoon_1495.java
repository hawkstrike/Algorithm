package BaekJoon.java;
// https://www.acmicpc.net/problem/1495

import java.util.Scanner;

public class baekjoon_1495 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n+1][m+1];

		dp[0][s] = 1;
		for(int i = 0; i < n; i++) {
			int index = sc.nextInt();
			for(int j = 0; j <= m; j++)
				if(dp[i][j] == 1) {
					if(j + index <= m)
						dp[i+1][j+index] = 1;
					if(j - index >= 0)
						dp[i+1][j-index] = 1;
				}
		}

		int max = -1;

		for(int i = 0; i <= m; i++)
			if(dp[n][i] != 0 && max < i)
				max = i;

		System.out.println(max);
		sc.close();
	}
}