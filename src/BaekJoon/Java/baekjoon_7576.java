package BaekJoon.Java;
// https://www.acmicpc.net/problem/7576

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_7576 {
	public static class coordinate{
		int x;
		int y;

		coordinate(){
			x = 1;
			y = 1;
		}

		coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] field = new int[n+2][m+2];
		int x = 0;
		int y = 0;

		for(int i = 1; i < field.length-1; i++) {
			for(int j = 1; j < field[i].length-1; j++) {
				field[i][j] = sc.nextInt();
				if (field[i][j] == 1) {
					x = i;
					y = j;
				}
			}
		}

		bfs(field, x, y);
		sc.close();
	}

	public static void bfs(int[][] field, int x, int y) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		int qSize = 0;
		int count = 0;

		for(int i = 1; i < field.length-1; i++) {
			for(int j = 1; j < field[i].length-1; j++)
				if(field[i][j] == 1)
					q.add(new coordinate(i, j));
		}

		qSize = q.size();

		while(!q.isEmpty()) {
			coordinate c = q.poll();

			if(incheck(field, c.x-1, c.y)) {
				if(field[c.x-1][c.y] != 1 && field[c.x-1][c.y] != -1) {
					field[c.x-1][c.y] = 1;
					q.add(new coordinate(c.x-1, c.y));
				}
			}

			if(incheck(field, c.x, c.y+1)) {
				if(field[c.x][c.y+1] != 1 && field[c.x][c.y+1] != -1) {
					field[c.x][c.y+1] = 1;
					q.add(new coordinate(c.x, c.y+1));
				}
			}

			if(incheck(field, c.x+1, c.y)) {
				if(field[c.x+1][c.y] != 1 && field[c.x+1][c.y] != -1) {
					field[c.x+1][c.y] = 1;
					q.add(new coordinate(c.x+1, c.y));
				}
			}

			if(incheck(field, c.x, c.y-1)) {
				if(field[c.x][c.y-1] != 1 && field[c.x][c.y-1] != -1) {
					field[c.x][c.y-1] = 1;
					q.add(new coordinate(c.x, c.y-1));
				}
			}

			qSize--;
			if(qSize == 0) {
				qSize = q.size();
				count++;
			}

		}

		count--;

		for(int i = 1; i < field.length-1; i++) {
			for(int j = 1; j < field[i].length-1; j++) {
				if(field[i][j] == 0)
					count = -1;
			}
		}

		System.out.println(count);
	}

	public static boolean incheck(int[][] field, int x, int y) {
		if((x > 0 && y > 0) && (x <= field.length-2 && y <= field[1].length-2))
			return true;

		return false;
	}
}