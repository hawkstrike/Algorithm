package Programmers.Practice.Level1;

// 정수 제곱근 판별
// https://programmers.co.kr/learn/courses/30/lessons/12934
public class Problem_12934 {
	
	public static void main(String[] args) {
		//long n = 121;
		long n = 3;
		
		System.out.println(solution(n));
	}
	
	public static long solution(long n) {
		long num = 1;
		
		while (num <= n) {
			if (num * num == n) {
				return (num + 1) * (num + 1);
			}
			
			num++;
		}
		
		return -1;
	}
}