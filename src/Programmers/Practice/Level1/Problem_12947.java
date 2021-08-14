package Programmers.Practice.Level1;

// 하샤드 수
// https://programmers.co.kr/learn/courses/30/lessons/12947
public class Problem_12947 {
	
	public static void main(String[] args) {
		int x = 13;
		
		System.out.println(solution(x));
	}
	
	public static boolean solution(int x) {
		int n = x;
		int rest = 0;
		
		while (n > 0) {
			rest += n % 10;
			n /= 10;
		}
		
		return (x % rest == 0) ? true : false;
	}
}