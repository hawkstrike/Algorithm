package BaekJoon.Java;
// https://www.acmicpc.net/problem/3055

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_3055 {
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
		int r = sc.nextInt();
		int c = sc.nextInt();
		char[][] field = new char[r][c];
		boolean[][] v = new boolean[r][c];

		sc.nextLine();

		for(int i = 0; i < r; i++) {
			String s = sc.nextLine();
			field[i] = s.toCharArray();
		}

		bfs(field, v);
		sc.close();
	}

	public static void bfs(char[][] field, boolean[][] v) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		Queue<coordinate> water = new LinkedList<coordinate>();
		coordinate c = null;
		coordinate w;
		int waterSize = 0;
		int beaverSize = 0;
		int count = 0;
		boolean check = false;
		boolean bCheck = true;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				if(field[i][j] == 'S') {
					q.add(new coordinate(i, j));
					v[i][j] = true;
					field[i][j] = '.';
				}

				if(field[i][j] == '*') {
					water.add(new coordinate(i, j));
				}
			}
		}

		waterSize = water.size();
		beaverSize = q.size();

		while(!q.isEmpty()) {
			c = q.poll();

			if(field[c.x][c.y] == 'D') {
				check = true;
				break;
			}

			while (!water.isEmpty() && bCheck == true) {
				w = water.poll();

				for (int i = 0; i < dx.length; i++) {
					int currX = w.x + dx[i];
					int currY = w.y + dy[i];

					if (currX >= 0 && currX < field.length && currY >= 0 && currY < field[0].length) {
						if (field[currX][currY] == '.') {
							water.add(new coordinate(currX, currY));
							field[currX][currY] = '*';
						}
					}
				}

				waterSize--;

				if(waterSize == 0) {
					waterSize = water.size();
					break;
				}
			}

			bCheck = false;

			for(int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];

				if(currX >= 0 && currX < field.length && currY >= 0 && currY < field[0].length) {
					if((field[currX][currY] == '.' || field[currX][currY] == 'D') && !v[currX][currY]) {
						q.add(new coordinate(currX, currY));
						v[currX][currY] = true;
					}
				}
			}

			beaverSize--;

			if(beaverSize == 0) {
				beaverSize = q.size();
				count++;
				bCheck = true;
			}
		}

		if(check == true)
			System.out.println(count);
		else
			System.out.println("KAKTUS");
	}
}