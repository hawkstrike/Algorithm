package LeetCode.Algorithms.Java;

import java.util.Hashtable;

// https://leetcode.com/problems/check-if-it-is-a-straight-line/
public class Check_If_It_Is_a_Straight_Line {
	public static void main(String[] args) {
		/*int[][] coordinates = {{1, 2},
								{2, 3},
								{3, 4},
								{4, 5},
								{5, 6},
								{6, 7}};*/
		
		int[][] coordinates = {{1, 1},
								{2, 2},
								{3, 4},
								{4, 5},
								{5, 6},
								{7, 7}};
		
		System.out.println(checkStraightLine(coordinates));
	}
	
	public static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 2) {
			return true;
		}
		
		double compareSlope = getSlope(coordinates[0], coordinates[coordinates.length - 1]);
		
		for (int i = 1; i < coordinates.length - 2; i++) {
			if(compareSlope != getSlope(coordinates[0], coordinates[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static double getSlope(int[] point1, int[] point2) {
		return (double) (point2[1] - point1[1]) / (point2[0] - point1[0]);
	}
}