package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/broken-calculator/
public class Broken_Calculator {
	public static void main(String[] args) {
		/*int X = 2;
		int Y = 3;*/
		/*int X = 5;
		int Y = 8;*/
		/*int X = 3;
		int Y = 10;*/
		int X = 1024;
		int Y = 1;
		
		System.out.println(brokenCalc(X, Y));
	}
	
	public static int brokenCalc(int X, int Y) {
		int answer = 0;
		
		while (Y > X) {
			answer++;
			
			if (Y % 2 == 1) {
				Y++;
			} else {
				Y /= 2;
			}
		}
		
		return answer + X - Y;
	}
}