package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/add-binary/
public class Basic_Calculator_II {
	public static void main(String[] args) {
		String s = "3+2*2";
		
		System.out.println(calculate(s));
	}
	
	public static int calculate(String s) {
		int currNum = 0;
		int lastNum = 0;
		int result = 0;
		char oper = '+';
		
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				currNum = (currNum * 10) + (c - '0');
			} else if (c != ' ') {
				lastNum = calculate(lastNum, currNum, oper);
				
				if (c == '+' || c == '-') {
					result += lastNum;
					lastNum = 0;
				}
				
				currNum = 0;
				oper = c;
			}
		}
		
		return result + calculate(lastNum, currNum, oper);
		
		/*if (s == null || s.length() == 0) {
			return 0;
		}
		
		s = s.trim().replaceAll(" ", "");
		
		int length = s.length();
		int currNum = 0;
		int lastNum = 0;
		int result = 0;
		char oper = '+';
		
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			
			if (Character.isDigit(c)) {
				currNum = (currNum * 10) + (c - '0');
			}
			
			if (!Character.isDigit(c) || i == length - 1) {
				if (oper == '+' || oper == '-') {
					result += lastNum;
					lastNum = (oper == '+') ? currNum : -currNum;
				} else if (oper == '*') {
					lastNum *= currNum;
				} else if (oper == '/') {
					lastNum /= currNum;
				}
				
				oper = c;
				currNum = 0;
			}
		}
		
		result += lastNum;
		
		return result;*/
	}
	
	public static int calculate(int num1, int num2, char oper) {
		if (oper == '+') {
			return num1 + num2;
		} else if (oper == '-') {
			return num1 - num2;
		} else if (oper == '*') {
			return num1 * num2;
		} else {
			return num1 / num2;
		}
	}
}