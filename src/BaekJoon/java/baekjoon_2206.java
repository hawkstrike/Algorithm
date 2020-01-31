package BaekJoon.java;
// https://www.acmicpc.net/problem/2206

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2206 {
	static int n, m;
	static int[][] field;
	static boolean[][][] visited;

	public static class coor {
		int x, y, count, block;

		coor(int x, int y, int count, int block) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.block = block;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		sc.nextLine();

		field = new int[n+2][m+2];
		visited = new boolean[n+2][m+2][2];

		for(int i = 1; i <= n; i++) {
			String s = sc.nextLine();

			for(int j = 0; j < s.length(); j++)
				field[i][j+1] = s.charAt(j) - 48;
		}

		bfs();
		sc.close();
	}

	public static void bfs() {
		Queue<coor> q = new LinkedList<coor>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		boolean check = false;
		int count = 1;

		q.add(new coor(1, 1, 1, 0));
		visited[1][1][0] = true;

		while(!q.isEmpty()) {
			coor c = q.poll();

			if(c.x == n && c.y == m) {
				check = true;
				count = c.count;
				break;
			}

			for(int i = 0; i < 4; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];

				if(currX >= 1 && currY >= 1 && currX <= n && currY <= m) {
					if (c.block == 0) {
						if (!visited[currX][currY][0] && field[currX][currY] == 0) {
							q.add(new coor(currX, currY, c.count + 1, 0));
							visited[currX][currY][0] = true;
						} else if (!visited[currX][currY][1] && field[currX][currY] == 1) {
							q.add(new coor(currX, currY, c.count + 1, 1));
							visited[currX][currY][1] = true;
						}
					} else {
						if (!visited[currX][currY][1] && field[currX][currY] == 0) {
							q.add(new coor(currX, currY, c.count+1, 1));
							visited[currX][currY][1] = true;
						}
					}
				}
			}
		}

		System.out.println((check) ? count : "-1");
	}
}