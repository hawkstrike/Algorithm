package LeetCode.Algorithms;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class Number_of_Steps_to_Reduce_a_Number_to_Zero {
	public static void main(String[] args) {
		int num = 10000000;
		System.out.println(numberOfSteps(num));
	}
	
	public static int numberOfSteps(int num) {
		int result = 0;
		
		while (num > 0) {
			num = (num % 2 == 0) ? num / 2 : num - 1;
			result++;
		}
		
		return result;
	}
}