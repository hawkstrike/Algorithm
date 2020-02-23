package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/reverse-integer/
public class Reverse_Integer {
	public static void main(String[] args) {
		int x = -1563847412;

		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
		boolean flag = false;
		int cal = 0;
		long num = 0;
		int result = 0;

		if(x < 0) {
			x *= -1;
			flag = true;
		}

		while(x > 0) {
			cal = x % 10;
			x /= 10;

			num = num * 10 + cal;
		}

		if(num > Integer.MAX_VALUE) {
			num = 0;
		}

		num *= flag ? -1 : 1;
		result = (int) num;

		return result;
	}
}