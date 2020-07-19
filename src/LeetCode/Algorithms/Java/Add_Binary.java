package LeetCode.Algorithms.Java;

import java.math.BigInteger;

// https://leetcode.com/problems/add-binary/
public class Add_Binary {
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		
		System.out.println(addBinary(a, b));
	}
	
	public static String addBinary(String a, String b) {
		return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
	}
}