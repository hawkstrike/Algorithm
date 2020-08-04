package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/power-of-four/
public class Power_of_Four {
	public static void main(String[] args) {
		int num = 16;
		
		System.out.println(isPowerOfFour(num));
	}
	
	public static boolean isPowerOfFour(int num) {
		return num > 0 && ((num & (num - 1)) == 0) && (num & 0xaaaaaaaa) == 0;
	}
}