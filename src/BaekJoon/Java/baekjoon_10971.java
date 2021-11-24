package BaekJoon.Java;
// https://www.acmicpc.net/problem/10971

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_10971 {
	static int n, sum = Integer.MAX_VALUE;
	static int[][] field;

	public static class coor {
		int x, y, cost, cnt;
		boolean[] v = new boolean[n+1];

		coor(int x, int y, int cost, int cnt, boolean[] v) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.cnt = cnt;

			for(int i = 1; i < v.length; i++)
				this.v[i] = v[i];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		field = new int[n+1][n+1];

		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				field[i][j] = sc.nextInt();

		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				if(field[i][j] != 0)
					bfs(i, j);

		System.out.println(sum);
		sc.close();
	}

	public static void bfs(int x, int y) {
		Queue<coor> q = new LinkedList<coor>();
		boolean[] v = new boolean[n+1];

		v[x] = true;
		q.add(new coor(x, y, field[x][y], 1, v));

		while(!q.isEmpty()) {
			coor c = q.poll();

			v = c.v;
			v[c.x] = true;

			for(int i = 1; i <= n; i++)
				if(field[c.y][i] != 0 && !c.v[i] && c.x != i)
					q.add(new coor(c.y, i, c.cost + field[c.y][i], c.cnt + 1, v));

			if(c.cnt == n - 1) {
				if(sum > c.cost + field[c.y][x] && field[c.y][x] != 0)
					sum = c.cost + field[c.y][x];
			}
		}
	}
}