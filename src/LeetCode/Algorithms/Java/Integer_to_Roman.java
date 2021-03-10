package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/integer-to-roman/
public class Integer_to_Roman {
	public static void main(String[] args) {
		//int num = 3;
		//int num = 58;
		int num = 4;
		
		System.out.println(intToRoman(num));
	}
	
	public static String intToRoman(int num) {
		String[] romanArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] numberArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < numberArr.length; i++) {
			while (num >= numberArr[i]) {
				num -= numberArr[i];
				sb.append(romanArr[i]);
			}
		}
		
		return sb.toString();
	}
}