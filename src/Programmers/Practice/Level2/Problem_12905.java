package Programmers.Practice.Level2;

// 가장 큰 정사각형 찾기
// https://programmers.co.kr/learn/courses/30/lessons/12905
public class Problem_12905 {
	
	public static void main(String[] args) {
		/*int[][] board = {{0, 1, 1, 1},
						{1, 1, 1, 1},
						{1, 1, 1, 1},
						{0, 0, 1, 0}};*/
		/*int[][] board = {{0, 0, 1, 1},
						{1, 1, 1, 1}};*/
		int[][] board = {{0, 0, 0, 0},
						{0, 0, 0, 0},
						{1, 1, 0, 0},
						{1, 1, 0, 0}};
		
		System.out.println(solution(board));
	}
	
	public static int solution(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = board[i - 1][j - 1];
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i][j] != 0) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		return max * max;
	}
}