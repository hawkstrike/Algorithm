package Goorm.Java.Level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://level.goorm.io/exam/43082/%EC%B5%9C%EB%8B%A8-%EA%B1%B0%EB%A6%AC-%EA%B5%AC%ED%95%98%EA%B8%B0/quiz/1
public class Problem_43082 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			field[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(num -> Integer.parseInt(num))
					.toArray();
		}
		
		bfs(field, n);
		
		br.close();
	}
	
	public static void bfs(int[][] field, int n) {
		Queue<coor> queue = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		queue.offer(new coor(0, 0, 1));
		field[0][0] = -1;
		
		while (!queue.isEmpty()) {
			coor c = queue.poll();
			
			if (c.x == n - 1 && c.y == n - 1) {
				System.out.println(c.count);
				return;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];
				
				if (currX >= 0 && currX < n && currY >= 0 && currY < n && field[currX][currY] == 1) {
					queue.offer(new coor(currX, currY, c.count + 1));
					field[currX][currY] = -1;
				}
			}
		}
	}
	
	public static class coor {
		int x;
		int y;
		int count;
		
		public coor(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}