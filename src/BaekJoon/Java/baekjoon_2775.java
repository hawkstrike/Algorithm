package BaekJoon.Java;
// https://www.acmicpc.net/problem/2775

import java.util.Scanner;

public class baekjoon_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] arr = new int[k+1][n+1];

			for(int j = 1; j <= n; j++)
				arr[0][j] = j;

			for(int j = 1; j <= k; j++) {
				for(int l = 1; l <= n; l++)
					for(int m = 1; m <= l; m++)
						arr[j][l] += arr[j-1][m];
			}

			System.out.println(arr[k][n]);
		}

		sc.close();
	}
}