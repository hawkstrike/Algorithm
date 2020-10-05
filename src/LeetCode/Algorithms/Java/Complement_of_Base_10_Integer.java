package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/complement-of-base-10-integer/
public class Complement_of_Base_10_Integer {
	public static void main(String[] args) {
		int N = 5;
		
		System.out.println(bitwiseComplement(N));
	}
	
	public static int bitwiseComplement(int N) {
		int length = Integer.toBinaryString(N).length();
		int pow = (int) Math.pow(2, length) - 1;
		
		return pow - N;
	}
}