package BaekJoon.java;
// https://www.acmicpc.net/problem/11404

import java.util.Scanner;

public class baekjoon_11404 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		int m = sc.nextInt();

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++)
				arr[i][j] = 100001;
		}

		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cost = sc.nextInt();

			if(cost < arr[x][y])
				arr[x][y] = cost;
		}

		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++)
				for(int j = 1; j <= n; j++)
					if(i != j)
						arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]);
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++)
				System.out.print((arr[i][j] == 100001) ? "0 " : arr[i][j] + " ");
			System.out.println();
		}

		sc.close();
	}

	public static int min(int x, int y) {
		return (x > y) ? y : x;
	}
}