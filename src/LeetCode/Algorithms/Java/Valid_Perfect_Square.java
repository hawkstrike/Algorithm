package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/valid-perfect-square/
public class Valid_Perfect_Square {
	public static void main(String[] args) {
		int num = 1 ;
		
		System.out.println(isPerfectSquare(num));
	}
	
	public static boolean isPerfectSquare(int num) {
		int left = 1;
		int right = num;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			long square = (long) mid * mid;
			
			if (square == num) {
				return true;
			} else if (square < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			
		}
		
		return false;
	}
}