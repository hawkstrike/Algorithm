package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/perform-string-shifts/
public class Perform_String_Shifts {
	public static void main(String[] args) {
		String s = "abc"; // "abcdefg";
		int[][] shift = {{1, 1}, {1, 1}, {0, 5}, {1, 1}}; // {{0, 1}, {1, 2}};
		
		System.out.println(stringShift(s, shift));
	}
	
	public static String stringShift(String s, int[][] shift) {
		int amount = 0;
		
		for (int i = 0; i < shift.length; i++) {
			if (shift[i][0] == 0) {
				amount -= shift[i][1];
			} else {
				amount += shift[i][1];
			}
		}
		
		String front = "";
		String back = "";
		
		if (amount > 0) {
			amount %= s.length();
			
			front = s.substring(s.length() - amount, s.length());
			back = s.substring(0, s.length() - amount);
		} else if (amount < 0) {
			amount = Math.abs(amount) % s.length();
			
			front = s.substring(amount);
			back = s.substring(0, amount);
		} else {
			return s;
		}
		
		return front + back;
	}
}