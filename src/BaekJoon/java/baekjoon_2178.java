package BaekJoon.java;
// https://www.acmicpc.net/problem/2178

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2178 {
	static class coordinate {
		int x;
		int y;
		int count;

		coordinate() {
			x = 1;
			y = 1;
			count = 1;
		}

		coordinate(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] field = new int[n+2][m+2];
		boolean[][] c = new boolean[n+2][m+2];

		sc.nextLine();

		for(int i = 1; i < field.length-1; i++) {
			String s = sc.nextLine();

			for(int j = 0; j < s.length(); j++)
				field[i][j+1] = s.charAt(j) - 48;
		}

		bfs(field, c);

		sc.close();
	}

	public static void bfs(int[][] field, boolean[][] c) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		coordinate coor = null;

		c[1][1] = true;
		q.add(new coordinate());

		while(!q.isEmpty()) {
			coor = q.poll();

			if(coor.x == field.length-2 && coor.y == field[1].length-2)
				break;

			// check can move up
			if(field[coor.x-1][coor.y] == 1 && !c[coor.x-1][coor.y]) {
				c[coor.x-1][coor.y] = true;
				q.add(new coordinate(coor.x-1, coor.y, coor.count+1));
			}

			// check can move right
			if(field[coor.x][coor.y+1] == 1 && !c[coor.x][coor.y+1]) {
				c[coor.x][coor.y+1] = true;
				q.add(new coordinate(coor.x, coor.y+1, coor.count+1));
			}

			// check can move down
			if(field[coor.x+1][coor.y] == 1 && !c[coor.x+1][coor.y]) {
				c[coor.x+1][coor.y] = true;
				q.add(new coordinate(coor.x+1, coor.y, coor.count+1));
			}

			// check can move left
			if(field[coor.x][coor.y-1] == 1 && !c[coor.x][coor.y-1]) {
				c[coor.x][coor.y-1] = true;
				q.add(new coordinate(coor.x, coor.y-1, coor.count+1));
			}


		} // end of while

		System.out.println(coor.count);
	}
}