package Programmers.Practice.Level2;

// 숫자의 표현
// https://programmers.co.kr/learn/courses/30/lessons/12924
public class Problem_12924 {
	
	public static void main(String[] args) {
		int n = 15;
		
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int count = 1;
		
		for (int i = 1; i <= n; i++) {
			int sum = i;
			
			for (int j = i + 1; j <= n; j++) {
				sum += j;
				
				if (sum > n) {
					break;
				} else if (sum == n) {
					count++;
					break;
				}
			}
		}
		
		return count;
	}
}