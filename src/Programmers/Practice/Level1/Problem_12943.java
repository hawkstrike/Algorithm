package Programmers.Practice.Level1;

// 콜라츠 추측
// https://programmers.co.kr/learn/courses/30/lessons/12943
public class Problem_12943 {
	
	public static void main(String[] args) {
		int n = 6;
		
		System.out.println(solution(n));
	}
	
	public static int solution(int num) {
		int count = 0;
		
		for (int i = 0; i < 500; i++) {
			if (num == 1) {
				return count;
			}
			
			if (num % 2 == 0) {
				num /= 2;
			} else if (num % 2 == 1) {
				num = (num * 3) + 1;
			}
			
			count++;
		}
		
		return -1;
	}
}