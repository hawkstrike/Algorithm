package LeetCode.Algorithms;

// https://leetcode.com/problems/minimum-time-visiting-all-points/
public class Minimum_Time_Visiting_All_Points {
	public static void main(String[] args){
		int[][] points = {{3, 2}, {-2 ,2}}; // {{1, 1}, {3, 4}, {-1, 0}};

		System.out.println(minTimeToVisitAllPoints(points));
	}
	
	public static int minTimeToVisitAllPoints(int[][] points) {
		int result = 0;
		
		for (int i = 0; i < points.length - 1; i++) {
			int x = Math.abs(points[i + 1][0] - points[i][0]);
			int y = Math.abs(points[i + 1][1] - points[i][1]);
			
			result += Math.max(x, y);
		}
		
		return result;
	}
}