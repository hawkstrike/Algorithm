package Programmers.Practice.Level2;

// 주식가격
// https://programmers.co.kr/learn/courses/30/lessons/42584
public class Problem_42584 {
	
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] result = solution(prices);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int[] prices) {
		int length = prices.length;
		int[] time = new int[length];
		int index = 0;
		
		for (int i = 0; i < length - 1; i++) {
			for (index = i + 1; index < length - 1; index++) {
				if (prices[index] < prices[i]) {
					break;
				}
			}
			
			time[i] = index - i;
		}
		
		return time;
	}
}