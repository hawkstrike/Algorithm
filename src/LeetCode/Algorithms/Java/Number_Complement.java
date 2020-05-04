package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/number-complement/
public class Number_Complement {
	public static void main(String[] args) {
		int num = 2147483647;
		
		System.out.println(findComplement(num));
	}
	
	public static int findComplement(int num) {
		return (int) (Math.pow(2, (int) (Math.log10(num) / Math.log10(2)) + 1) - 1) ^ num;
		//return num ^ ((Integer.highestOneBit(num) << 1) - 1);
	}
}