package Startup.Coding.Festival.First;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test_5 {
	public static class Eyes {
		int x;
		int y;
		int count;
		
		public Eyes(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = br.readLine();
		int n = inputLine.charAt(0) - 48;
		int m = inputLine.charAt(2) - 48;
		char[][] field = new char[m][n];
		
		for (int i = 0; i < m; i++) {
			field[i] = br.readLine().toCharArray();
		}
		
		Queue<Eyes> queue = new LinkedList<>();
		int[] dx = {0, 0, 1}; // left, right, down
		int[] dy = {-1, 1, 0};
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			if (field[0][i] == 'c') {
				queue.offer(new Eyes(0, i, 0));
			}
		}
		
		while (!queue.isEmpty()) {
			Eyes curr = queue.poll();
			
			if (curr.x == m - 1) {
				min = Math.min(min, curr.count);
			}
			
			for (int i = 0; i < dx.length; i++) {
				int currX = curr.x + dx[i];
				int currY = curr.y + dy[i];
				
				if (currX >= 0 && currX < m && currY >= 0 && currY < n && field[currX][currY] == '.') {
					if (dy[i] != 0) {
						queue.offer(new Eyes(currX, currY, curr.count + 1));
					} else {
						queue.offer(new Eyes(currX, currY, curr.count));
					}
					
					field[currX][currY] = 'x';
				}
			}
		}
		
		System.out.println(min);
	}
	
}