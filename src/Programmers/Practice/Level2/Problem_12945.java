package Programmers.Practice.Level2;

// 피보나치 수
// https://programmers.co.kr/learn/courses/30/lessons/12945
public class Problem_12945 {
	
	public static void main(String[] args) {
		int n = 3;
		
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int first = 0;
		int second = 1;
		int fibo = 0;
		
		for (int i = 1; i < n; i++) {
			fibo = (first + second) % 1234567;
			first = second;
			second = fibo;
		}
		
		return fibo;
	}
}