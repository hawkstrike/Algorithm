package BaekJoon.java;
// https://www.acmicpc.net/problem/2468

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2468 {
	static int count = 0;

	public static class coordinate {
		int x;
		int y;
		coordinate(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] field = new int[n+2][n+2];
		boolean[][] v = new boolean[n+2][n+2];
		int maxCount = 1;
		int max = 1;

		for(int i = 1; i < field.length-1; i++) {
			for(int j = 1; j < field.length-1; j++) {
				field[i][j] = sc.nextInt();
				if(field[i][j] > max)
					max = field[i][j];
			}
		}

		for (int flood = 0; flood <= max; flood++) {
			for (int i = 1; i < field.length - 1; i++) {
				for (int j = 1; j < field.length - 1; j++) {
					if (!v[i][j] && field[i][j] > flood)
						bfs(field, v, flood, i, j);
				}
			}

			for (int k = 1; k < v.length - 1; k++) {
				for (int l = 1; l < v.length - 1; l++)
					v[k][l] = false;
			}

			if(maxCount < count)
				maxCount = count;

			count = 0;
		}

		System.out.println(maxCount);
		sc.close();
	}

	public static void bfs(int[][] field, boolean[][] v, int flood, int x, int y) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		coordinate c = null;

		q.add(new coordinate(x, y));
		v[x][y] = true;
		count++;

		while (!q.isEmpty()) {
			c = q.poll();

			for (int k = 0; k < dx.length; k++) {
				int currX = c.x + dx[k];
				int currY = c.y + dy[k];

				if (field[currX][currY] > flood && !v[currX][currY]) {
					q.add(new coordinate(currX, currY));
					v[currX][currY] = true;
				}
			}
		}
	}
}