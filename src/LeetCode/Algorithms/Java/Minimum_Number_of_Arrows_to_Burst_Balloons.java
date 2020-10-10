package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class Minimum_Number_of_Arrows_to_Burst_Balloons {
	public static void main(String[] args) {
		int[][] points = {{10, 16},
							{2, 8},
							{1, 6},
							{7, 12}};
		
		System.out.println(findMinArrowShots(points));
	}
	
	public static int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
		
		int arrow = 1;
		int limit = points[0][1];
		
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= limit) {
				limit = Math.min(limit, points[i][1]);
			} else {
				arrow++;
				limit = points[i][1];
			}
		}
		
		return arrow;
	}
}