package LeetCode.Algorithms.Java;

import java.util.List;

// https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
public class Leftmost_Column_with_at_Least_a_One {
	interface BinaryMatrix {
		public int get(int x, int y);
		public List<Integer> dimensions();
	}
	
	public static void main(String[] args) {
	
	}
	
	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		int result = -1;
		int n = binaryMatrix.dimensions().get(0);
		int m = binaryMatrix.dimensions().get(1);
		int x = 0;
		int y = m - 1;
		
		while (x < n && y >= 0) {
			int value = binaryMatrix.get(x, y);
			
			if (value == 0) {
				x++;
			} else if (value == 1) {
				result = y;
				y--;
			}
			
			if (x > n) {
				result = -1;
			}
		}
		
		return result;
	}
}