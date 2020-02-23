package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class Find_Numbers_with_Even_Number_of_Digits {
	public static void main(String[] args) {
		int[] nums = {555, 901, 482, 1771};// {12, 345, 2, 6, 7896};

		System.out.println(findNumbers(nums));
	}

	public static int findNumbers(int[] nums) {
		int result = 0;

		for(int n : nums) {
			String temp = String.valueOf(n);

			if(temp.length() % 2 == 0)
				result++;
		}

		/*for(int n : nums) {
			int count = 0;

			while(n > 0) {
				n /= 10;
				count++;
			}

			if(count % 2 == 0)
				result++;
		}*/

		return result;
	}
}