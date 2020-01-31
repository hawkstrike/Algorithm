package BaekJoon.java;
// https://www.acmicpc.net/problem/1012

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1012 {
	public static class coordinate {
		int x;
		int y;
		coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean checked(int[][] field, int x, int y) {
		if(x > 0 && y > 0 && x < (field.length-1) && y < (field[0].length-1))
			return true;

		return false;
	}

	public static void bfs(int[][] field, boolean[][] visited, int x, int y) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		coordinate c;

		q.add(new coordinate(x, y));

		while(!q.isEmpty()) {
			c = q.poll();

			for(int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];
				if(checked(field, currX, currY)) {
					if(field[currX][currY] == 1 && !visited[currX][currY]) {
						visited[currX][currY] = true;
						q.add(new coordinate(currX, currY));
					}
				}
			}
		} // end of while
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		int[][] field = null;
		boolean[][] visited = null;
		int count = 0;

		for(int i = 0; i < test_case; i++) {
			int m = sc.nextInt(); // 가로
			int n = sc.nextInt(); //; 세로
			field = new int[m+2][n+2];
			visited = new boolean[m+2][n+2];
			int k = sc.nextInt(); // 배추 개수
			count = 0;
			for(int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				field[x+1][y+1] = 1;
			}

			for(int j = 1; j < field.length-1; j++) {
				for(int l = 1; l < field[i].length-1; l++) {
					if(field[j][l] == 1 && !visited[j][l]) {
						bfs(field, visited, j, l);
						count++;
					}
				}
			}
			System.out.println(count);
		}

		sc.close();
	}
}