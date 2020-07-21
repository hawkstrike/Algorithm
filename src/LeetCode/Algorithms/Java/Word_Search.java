package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/word-search/
public class Word_Search {
	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'},
						{'S', 'F', 'C', 'S'},
						{'A', 'D', 'E', 'E'}};
		String[] words = {"ABCCED", "SEE", "ABCD"};
		
		for (String word : words) {
			System.out.println(exist(board, word));
		}
	}
	
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && recurrentWordSearch(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean recurrentWordSearch(char[][] board, String word, int x, int y, int index) {
		if (index == word.length()) {
			return true;
		}
		
		if (x == -1 || y == -1 || x == board.length || y == board[0].length || board[x][y] != word.charAt(index)) {
			return false;
		}
		
		char temp = board[x][y];
		
		board[x][y] = ' ';
		
		boolean result = recurrentWordSearch(board, word, x - 1, y, index + 1) ||
				recurrentWordSearch(board, word, x, y + 1, index + 1) ||
				recurrentWordSearch(board, word, x + 1, y, index + 1) ||
				recurrentWordSearch(board, word, x, y - 1, index + 1);
		
		board[x][y] = temp;
		
		return result;
	}
}