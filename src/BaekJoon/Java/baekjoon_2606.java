package BaekJoon.Java;
// https://www.acmicpc.net/problem/2606

import java.util.Scanner;

public class baekjoon_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] adj = new int[n+1][n+1];
		int count = 0;

		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x][y] = adj[y][x] = 1;
		}

		for(int k = 1; k < adj.length; k++) {
			for(int i = 1; i < adj.length; i++)
				for(int j = 1; j < adj.length; j++)
					if(adj[i][k] == 1 && adj[k][j] == 1)
						adj[i][j] = 1;
		}

		for(int i = 2; i < adj.length; i++) {
			if(adj[1][i] == 1)
				count++;
		}

		System.out.println(count);
		sc.close();
	}
}