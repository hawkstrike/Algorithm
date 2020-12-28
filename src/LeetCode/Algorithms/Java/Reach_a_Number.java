package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/reach-a-number/
public class Reach_a_Number {
	public static void main(String[] args) {
		int target = 3;
		
		System.out.println(reachNumber(target));
	}
	
	public static int reachNumber(int target) {
		int k = 0;
		
		target = Math.abs(target);
		
		while (target > 0) {
			target -= ++k;
		}
		
		return (target % 2 == 0) ? k : k + 1 + k % 2;
	}
}