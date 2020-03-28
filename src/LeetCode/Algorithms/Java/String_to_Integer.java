package LeetCode.Algorithms.Java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://leetcode.com/problems/string-to-integer-atoi/
public class String_to_Integer {
	public static void main(String[] args){
		String str = "3.14159"; // "-5-"; // "0-1"; // "   -42"; // "-"; // "-91283472332"; // "words and 987"; // "4193 with words"; // "20000000000000000000"; //"   -04f"; // "  -0012a42"; // "-42";
		
		System.out.println(myAtoi(str));
	}
	
	public static int myAtoi(String str) {
		int result = 0;
		String regex = "([-+]?\\d+)([\\s+-.\\da-zA-Z]*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str.trim());
		
		if (matcher.matches()) {
			try {
				System.out.println(matcher.group(1));
				result = Integer.parseInt(matcher.group(1));
				
				return result;
			} catch (Exception e) {
				if (str.startsWith("-")) {
					return Integer.MIN_VALUE;
				} else {
					return Integer.MAX_VALUE;
				}
			}
		} else {
			return result;
		}
	}
}