package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/reverse-bits/
public class Reverse_Bits {
	public static void main(String[] args) {
		int n = 43261596;
		
		System.out.println(reverseBits(n));
	}
	
	public static int reverseBits(int n) {
		return Integer.reverse(n);
	}
}