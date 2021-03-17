package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/generate-random-point-in-a-circle/
public class Generate_Random_Point_in_a_Circle {
	public static class Solution {
		private double x;
		private double y;
		private double radius;
		
		public Solution(double radius, double x_center, double y_center) {
			this.x = x_center;
			this.y = y_center;
			this.radius = radius;
		}
		
		public double[] randPoint() {
			double angle = Math.random() * 2 * Math.PI;
			double hypotenuse = Math.sqrt(Math.random()) * this.radius;
			double adjacent = Math.cos(angle) * hypotenuse;
			double opposite = Math.sin(angle) * hypotenuse;
			
			return new double[]{this.x + adjacent, this.y + opposite};
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution(1, 0, 0);
		double[] pointArr = solution.randPoint();
		
		System.out.println(pointArr[0] + " | " + pointArr[1]);
	}
}