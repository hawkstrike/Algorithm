package BaekJoon.java;
// https://www.acmicpc.net/problem/11403

import java.util.Scanner;

public class baekjoon_11403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] adj = new int[n+1][n+1];

		for(int i = 1; i < adj.length; i++) {
			for(int j = 1; j < adj.length; j++)
				adj[i][j] = sc.nextInt();
		}

		for(int k = 1; k < adj.length; k++) {
			for(int i = 1; i < adj.length; i++)
				for(int j = 1; j < adj.length; j++)
					if(adj[i][k] == 1 && adj[k][j] == 1)
						adj[i][j] = 1;
		}

		for(int i = 1; i < adj.length; i++) {
			for(int j = 1; j < adj.length; j++)
				System.out.print(adj[i][j] + " ");
			System.out.println();
		}

		sc.close();
	}
}