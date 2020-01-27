package LeetCode.Algorithms;

// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
public class Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
	public static void main(String[] args) {
		int n = 234;

		System.out.println(subtractProductAndSum(n));
	}

	public static int subtractProductAndSum(int n) {
		int multi = 1;
		int sum = 0;
		int rest = 0;

		while(n > 0) {
			rest = n % 10;
			n /= 10;

			multi *= rest;
			sum += rest;
		}

		return multi - sum;
	}
}