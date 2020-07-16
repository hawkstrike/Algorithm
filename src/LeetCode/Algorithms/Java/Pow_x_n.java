package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/powx-n/
public class Pow_x_n {
	public static void main(String[] args) {
		double x = 2.00000;
		int n = 10;
		
		System.out.println(myPow(x, n));
	}
	
	public static double myPow(double x, int n) {
		return Math.pow(x, n);
	}
}