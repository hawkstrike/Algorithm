package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/arranging-coins/
public class Arranging_Coins {
	public static void main(String[] args) {
		int n = 1;
		
		System.out.println(arrangeCoins(n));
	}
	
	public static int arrangeCoins(int n) {
		/*if (n == 0) {
			return 0;
		}
		
		int i = 1;
		
		while (n >= i) {
			n -= i++;
		}
		
		return (i - 1);*/
		return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
	}
}