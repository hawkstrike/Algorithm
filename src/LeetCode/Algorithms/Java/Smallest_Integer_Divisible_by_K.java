package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/smallest-integer-divisible-by-k/
public class Smallest_Integer_Divisible_by_K {
	public static void main(String[] args) {
		int K = 17;
		
		System.out.println(smallestRepunitDivByK(K));
	}
	
	public static int smallestRepunitDivByK(int K) {
		int rest = 0;
		
		for (int length = 1; length <= K; length++) {
			rest = (rest * 10 + 1) % K;
			
			if (rest == 0) {
				return length;
			}
		}
		
		return -1;
	}
}