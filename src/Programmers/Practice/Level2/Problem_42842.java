package Programmers.Practice.Level2;

// 카펫
// https://programmers.co.kr/learn/courses/30/lessons/42842
public class Problem_42842 {
	
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		int[] result = solution(brown, yellow);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int brown, int yellow) {
		int expression = (int) Math.sqrt(Math.pow(brown + 4, 2) / 4 - 4 * (brown + yellow));
		int width = ((brown + 4) / 2 + expression) / 2;
		int height = ((brown + 4) / 2 - expression) / 2;
		
		return new int[] {width, height};
	}
}