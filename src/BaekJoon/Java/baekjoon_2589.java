package BaekJoon.Java;
// https://www.acmicpc.net/problem/2589

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2589 {
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

		int col = sc.nextInt();
		int row = sc.nextInt();

		sc.nextLine();

		int[][] field = new int[col+2][row+2];
		boolean[][] visited = new boolean[col+2][row+2];
		coordinate c = new coordinate(0, 0, 0);

		for(int i = 1; i < field.length-1; i++) {
			String s = sc.nextLine();

			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == 'W')
					field[i][j+1] = 0;
				else
					field[i][j+1] = 1;
			}
		}

		for(int i = 1; i < field.length-1; i++) {
			for(int j = 1; j < field[i].length-1; j++) {
				if(field[i][j] != 0) {
					coordinate temp = bfs(field, visited, i, j);
					if(temp.count > c.count)
						c = temp;
				}
				for(int k = 1; k < visited.length-1; k++) {
					for(int l = 1; l < visited[k].length-1; l++)
						visited[k][l] = false;
				}
			}
		}

		coordinate result = bfs(field, visited, c.x, c.y);
		System.out.println(result.count);
		sc.close();
	}

	public static coordinate bfs(int[][] field, boolean[][] visited, int x, int y) {
		Queue<coordinate> q = new LinkedList<coordinate>();
		coordinate c = new coordinate(x, y, 0);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		q.add(c);
		visited[x][y] = true;

		while(!q.isEmpty()) {
			c = q.poll();

			for(int i = 0; i < dx.length; i++) {
				int currX = c.x;
				int currY = c.y;

				if(ischecked(field.length-2, field[0].length-2, currX+dx[i], currY+dy[i])) {
					if (field[currX+dx[i]][currY+dy[i]] == 1 && !visited[currX+dx[i]][currY+dy[i]]) {
						currX += dx[i];
						currY += dy[i];
						visited[currX][currY] = true;
						q.add(new coordinate(currX, currY, c.count+1));
					}
				}
			}
		}

		return c;
	}

	public static boolean ischecked(int col, int row, int x, int y) {
		if((x > 0 && y > 0) &&  (x <= col && y <= row))
			return true;

		return false;
	}
}