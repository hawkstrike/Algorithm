package LeetCode.Algorithms.Java;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/surrounded-regions/
public class Surrounded_Regions {
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'},
						{'X', 'O', 'O', 'X'},
						{'X', 'X', 'O', 'X'},
						{'X', 'O', 'O', 'X'}};
		
		solve(board);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		
		int n = board.length;
		int m = board[0].length;
		
		for (int i = 0; i < n; i++) {
			if (board[i][0] == 'O') {
				bfs(board, i, 0);
			}
			if (board[i][m - 1] == 'O') {
				bfs(board, i, m - 1);
			}
		}
		
		for (int i = 0; i < m; i++) {
			if (board[0][i] == 'O') {
				bfs(board, 0, i);
			}
			if (board[n - 1][i] == 'O') {
				bfs(board, n - 1, i);
			}
		}
		
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '+') {
					board[i][j] = 'O';
				}
			}
		}
	}
	
	public static void bfs(char[][] board, int x, int y) {
		Queue<Point> q = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int n = board.length;
		int m = board[0].length;
		
		board[x][y] = '+';
		q.offer(new Point(x, y));
		
		while (!q.isEmpty()) {
			Point point = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int currX = point.x + dx[i];
				int currY = point.y + dy[i];
				
				if (currX >= 0 && currX < n && currY >= 0 && currY < m && board[currX][currY] == 'O') {
					board[currX][currY] = '+';
					q.offer(new Point(currX, currY));
				}
			}
		}
	}
}