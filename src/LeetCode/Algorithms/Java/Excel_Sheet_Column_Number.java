package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/excel-sheet-column-number/
public class Excel_Sheet_Column_Number {
	public static void main(String[] args) {
		String s = "AAAA";
		
		System.out.println(titleToNumber(s));
	}
	
	public static int titleToNumber(String s) {
		int result = 0;
		int pow = s.length() - 1;
		
		for (int i = 0; i < s.length(); i++) {
			result += Math.pow(26, pow--) * (s.charAt(i) - 64);
		}
		
		return result;
	}
}