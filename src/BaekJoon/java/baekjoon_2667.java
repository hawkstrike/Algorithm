package BaekJoon.java;
// https://www.acmicpc.net/problem/2667

import java.util.*;
import java.util.Queue;

public class baekjoon_2667 {
	static int area = 0;

	public static class coordinate {
		int x;
		int y;

		coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		int[][] field = new int[n+2][n+2];
		boolean[][] v = new boolean[n+2][n+2];
		List<Integer> list = new LinkedList<>();

		for(int i = 1; i < field.length-1; i++) {
			String s = sc.nextLine();
			for(int j = 1; j < field.length-1; j++)
				field[i][j] = s.charAt(j-1) - 48;
		}

		for(int i = 1; i < field.length-1; i++)
			for(int j = 1; j < field.length-1; j++)
				if(field[i][j] == 1 && !v[i][j])
					list.add(bfs(field, v, i, j));

		Collections.sort(list);
		System.out.println(area);

		for(int i : list)
			System.out.println(i);

		sc.close();
	}

	public static int bfs(int[][] field, boolean[][] v, int x, int y) {
		Queue<coordinate> q = new LinkedList<>();
		coordinate c = new coordinate(x, y);
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int count = 1;

		q.add(c);
		v[x][y] = true;
		area++;

		while(!q.isEmpty()) {
			c = q.poll();

			for(int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];

				if(field[currX][currY] == 1 && !v[currX][currY]) {
					v[currX][currY] = true;
					q.add(new coordinate(currX, currY));
					count++;
				}
			}
		}

		return count;
	}
}