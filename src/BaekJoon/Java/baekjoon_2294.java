package BaekJoon.Java;
// https://www.acmicpc.net/problem/2294

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_2294 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m;
		int[] dp = new int[k+1];

		Arrays.fill(dp, -1);

		dp[0] = 0;
		for(int i = 0; i < n; i++) {
			m = sc.nextInt();

			for(int j = 1; j <= k; j++) {
				if(j - m >= 0 && dp[j-m] != -1)
					if(dp[j] == -1 || dp[j] > dp[j-m] + 1)
						dp[j] = dp[j-m] + 1;
			}
		}

		System.out.println(dp[k]);
		sc.close();
	}
}