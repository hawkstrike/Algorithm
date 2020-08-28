package LeetCode.Algorithms.Java;

import java.util.Random;

// https://leetcode.com/problems/implement-rand10-using-rand7/
public class Implement_Rand10_Using_Rand7 {
	public static void main(String[] args) {
	
	}
	
	public static int rand10() {
		int row;
		int col;
		int index;
		
		do {
			row = rand7();
			col = rand7();
			index = col + (row - 1) * 7;
		} while (index > 40);
		
		return 1 + (index - 1) % 10;
	}
	
	public static int rand7() {
		return new Random().nextInt(7) + 1;
	}
}