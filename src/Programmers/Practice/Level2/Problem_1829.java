package Programmers.Practice.Level2;

import java.util.LinkedList;
import java.util.Queue;

// 카카오프렌즈 컬러링북
// https://programmers.co.kr/learn/courses/30/lessons/1829
public class Problem_1829 {
	
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0},
							{1, 2, 2, 0},
							{1, 0, 0, 1},
							{0, 0, 0, 1},
							{0, 0, 0, 3},
							{0, 0, 0, 3}};
		int[] result = solution(m, n, picture);
		
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		boolean[][] visited = new boolean[m][n];
		int count = 0;
		int maxArea = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visited[i][j]) {
					maxArea = Math.max(maxArea, bfs(picture, visited, m, n, i, j, picture[i][j]));
					count++;
				}
			}
		}
		
		return new int[] {count, maxArea};
	}
	
	public static int bfs(int[][] picture, boolean[][] visited, int m, int n, int x, int y, int type) {
		Queue<coor> queue = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int area = 1;
		
		queue.offer(new coor(x, y));
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			coor c = queue.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];
				
				if (currX >= 0 && currY >= 0 && currX < m && currY < n && picture[currX][currY] == type && !visited[currX][currY]) {
					queue.offer(new coor(currX, currY));
					visited[currX][currY] = true;
					area++;
				}
			}
		}
		
		return area;
	}
	
	public static class coor {
		int x;
		int y;
		
		public coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}