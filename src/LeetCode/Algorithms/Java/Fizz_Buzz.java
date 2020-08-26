package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/add-binary/
public class Fizz_Buzz {
	public static void main(String[] args) {
		int n = 15;
		List<String> result = fizzBuzz(n);
		
		for (String s : result) {
			System.out.println(s);
		}
	}
	
	public static List<String> fizzBuzz(int n) {
		List<String> list = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			StringBuffer sb = new StringBuffer();
			
			if (i % 3 == 0) {
				sb.append("Fizz");
			}
			
			if (i % 5 == 0) {
				sb.append("Buzz");
			}
			
			if ("".equals(sb.toString())) {
				sb.append(Integer.toString(i));
			}
			
			list.add(sb.toString());
		}
		
		return list;
	}
}