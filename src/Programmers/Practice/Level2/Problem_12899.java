package Programmers.Practice.Level2;

// 124 나라의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12899
public class Problem_12899 {
	
	public static void main(String[] args) {
		int n = 7;
		
		System.out.println(solution(n));
	}
	
	public static String solution(int n) {
		StringBuffer sb = new StringBuffer();
		
		while (n > 0) {
			int remain = n % 3;
			
			if (remain == 0) {
				n = n / 3 - 1;
				remain = 4;
			} else {
				n /= 3;
			}
			
			sb.append(remain);
		}
		
		return sb.reverse().toString();
	}
}