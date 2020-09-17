package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/robot-bounded-in-circle/
public class Robot_Bounded_In_Circle {
	public static void main(String[] args) {
		String instructions = "GGLLGG";
		
		System.out.println(isRobotBounded(instructions));
	}
	
	public static boolean isRobotBounded(String instructions) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int x = 0;
		int y = 0;
		int direction = 0;
		
		for (char c : instructions.toCharArray()) {
			if (c == 'G') {
				x += dx[direction];
				y += dy[direction];
			} else if (c == 'L') {
				direction = (direction + 1) % 4;
			} else {
				direction = (direction + 3) % 4;
			}
		}
		
		return (x == 0 && y == 0) || (direction != 0);
	}
}