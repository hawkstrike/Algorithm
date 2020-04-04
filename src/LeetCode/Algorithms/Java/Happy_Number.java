package LeetCode.Algorithms.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

// https://leetcode.com/problems/happy-number/
public class Happy_Number {
	public static void main(String[] args) {
		int n = 19;
		
		System.out.println(isHappy(n));
	}
	
	public static boolean isHappy(int n) {
		HashSet<Integer> hashSet = new HashSet<>();
		
		hashSet.add(n);
		
		while (n != 1) {
			n = computeNumber(n);
			
			if (hashSet.contains(n)) {
				return false;
			} else {
				hashSet.add(n);
			}
		}
		
		return true;
	}
	
	public static int computeNumber(int n) {
		int sum = 0;
		
		while (n > 0) {
			sum += Math.pow(n % 10, 2);
			n /= 10;
		}
		
		return sum;
	}
}