package BaekJoon.java;
// https://www.acmicpc.net/problem/10942

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_10942 {
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		dp = new int[n][n];

		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}

		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while(m-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			sb.append(palindrome(x-1, y-1) + "\n");
		}

		System.out.println(sb.toString());
		sc.close();
	}

	public static int palindrome(int x, int y) {
		if(dp[x][y] >= 0)
			return dp[x][y];

		if(x == y)
			return 1;
		else if(x + 1 == y) {
			if(arr[x] == arr[y])
				return 1;
			else
				return 0;
		}

		if(arr[x] != arr[y])
			return dp[x][y] = 0;
		else
			return dp[x][y] = palindrome(x + 1, y - 1);
	}
}