package BaekJoon.Java;
// https://www.acmicpc.net/problem/7562

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_7562 {
	public static class coordinate {
		int x;
		int y;
		int count;

		coordinate(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();

		for(int i = 0; i < test_case; i++) {
			int n = sc.nextInt();
			int[][] field = new int[n+4][n+4];
			boolean[][] v = new boolean[n+4][n+4];
			int startX = sc.nextInt()+2;
			int startY = sc.nextInt()+2;
			field[startX][startY] = 1;
			int endX = sc.nextInt()+2;
			int endY = sc.nextInt()+2;

			bfs(field, v, startX, startY, endX, endY);
		}

		sc.close();
	}

	public static void bfs(int[][] field, boolean[][] v, int startX, int startY, int endX, int endY) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		coordinate c = new coordinate(startX, startY, 0);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		v[startX][startY] = true;
		q.add(c);

		while(!q.isEmpty()) {
			c = q.poll();

			if(c.x == endX && c.y == endY)
				break;

			for(int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];
				int count = c.count;

				if(i == 0) { // north
					if (check(field, currX-1, currY-1)) {// turn left
						if (!v[currX-1][currY-1]) {
							q.add(new coordinate(currX-1, currY-1, count+1));
							v[currX-1][currY-1] = true;
						}
					}

					if(check(field, currX-1, currY+1)) { // turn right
						if(!v[currX-1][currY+1]) {
							q.add(new coordinate(currX-1, currY+1, count+1));
							v[currX-1][currY+1] = true;
						}
					}
				} // end of north if

				if(i == 1) { // east
					if(check(field, currX-1, currY+1)) { // turn top
						if(!v[currX-1][currY+1]) {
							q.add(new coordinate(currX-1, currY+1, count+1));
							v[currX-1][currY+1] = true;
						}
					}

					if(check(field, currX+1, currY+1)) { // turn down
						if(!v[currX+1][currY+1]) {
							q.add(new coordinate(currX+1, currY+1, count+1));
							v[currX+1][currY+1] = true;
						}
					}
				} // end of east if

				if(i == 2) { // south
					if(check(field, currX+1, currY-1)) { // turn left
						if(!v[currX+1][currY-1]) {
							q.add(new coordinate(currX+1, currY-1, count+1));
							v[currX+1][currY-1] = true;
						}
					}

					if(check(field, currX+1, currY+1)) { // turn right
						if(!v[currX+1][currY+1]) {
							q.add(new coordinate(currX+1, currY+1, count+1));
							v[currX+1][currY+1] = true;
						}
					}
				} // end of south if

				if(i == 3) { // west
					if(check(field, currX-1, currY-1)) { // turn top
						if(!v[currX-1][currY-1]) {
							q.add(new coordinate(currX-1, currY-1, count+1));
							v[currX+1][currY+1] = true;
						}
					}

					if(check(field, currX+1, currY-1)) { // turn down
						if(!v[currX+1][currY-1]) {
							q.add(new coordinate(currX+1, currY-1, count+1));
							v[currX+1][currY-1] = true;
						}
					}
				} // end of west if
			} // end of for
		}

		System.out.println(c.count);
	}

	public static boolean check(int[][] field, int x, int y) {
		if(x > 1 && y > 1 && x < field.length-2 && y < field.length-2)
			return true;

		return false;
	}
}