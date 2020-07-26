package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/add-digits/
public class Add_Digits {
	public static void main(String[] args) {
		int num = 38;
		
		System.out.println(addDigits(num));
	}
	
	public static int addDigits(int num) {
		if (num == 0) {
			return 0;
		} else if (num % 9 == 0) {
			return 9;
		}
		
		return num % 9;
	}
}