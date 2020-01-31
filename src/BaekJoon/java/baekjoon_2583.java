package BaekJoon.java;
// https://www.acmicpc.net/problem/2583

import java.util.*;

public class baekjoon_2583 {
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
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] field = new int[m+2][n+2];
		boolean[][] c = new boolean[m+2][n+2];
		List<Integer> list = new ArrayList<Integer>();

		for(int i = 1; i < field.length-1; i++)
			for(int j = 1; j < field[i].length-1; j++)
				field[i][j] = 1;

		for(int i = 0; i < k; i++) {
			int x1 = sc.nextInt() + 1;
			int y1 = sc.nextInt() + 1;
			int x2 = sc.nextInt() + 1;
			int y2 = sc.nextInt() + 1;

			for(int j = y1; j < y2; j++)
				for(int l = x1; l < x2; l++)
					field[j][l] = 0;
		}

		for(int i = 1; i < field.length-1; i++) {
			for(int j = 1; j < field[i].length-1; j++) {
				if(field[i][j] == 1 && !c[i][j])
					list.add(bfs(field, c, i, j));
			}
		}

		Collections.sort(list);
		System.out.println(area);

		for(int i : list)
			System.out.print(i + " ");

		sc.close();
	}

	public static int bfs(int[][] field, boolean[][] c, int x, int y) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		coordinate coor = new coordinate(x, y);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int count = 1;

		q.add(coor);
		c[x][y] = true;
		area++;

		while(!q.isEmpty()) {
			coor = q.poll();

			for(int i = 0; i < dx.length; i++) {
				int currX = coor.x + dx[i];
				int currY = coor.y + dy[i];

				if(field[currX][currY] == 1 && !c[currX][currY]) {
					c[currX][currY] = true;
					q.add(new coordinate(currX, currY));
					count++;
				}
			}
		} // end of while
		return count;
	}
}