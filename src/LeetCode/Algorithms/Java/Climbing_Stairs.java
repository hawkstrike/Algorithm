package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/climbing-stairs/
public class Climbing_Stairs {
	public static void main(String[] args) {
		int n = 5;
		
		System.out.println(climbStairs(n));
	}
	
	public static int climbStairs(int n) {
		int first = 0;
		int second = 1;
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			result = first + second;
			first = second;
			second = result;
		}
		
		return result;
	}
}