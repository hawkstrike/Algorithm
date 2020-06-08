package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/power-of-two/
public class Power_of_Two {
	public static void main(String[] args) {
		int n = 218;
		
		System.out.println(isPowerOfTwo(n));
	}
	
	public static boolean isPowerOfTwo(int n) {
		return n <= 0 ? false : (n & (n - 1)) == 0;
	}
}