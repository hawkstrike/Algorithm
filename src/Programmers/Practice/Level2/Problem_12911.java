package Programmers.Practice.Level2;

// 다음 큰 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12911
public class Problem_12911 {
	
	public static void main(String[] args) {
		//int n = 78;
		int n = 15;
		
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int nextNumber = n + 1;
		int bitCount = Integer.bitCount(n);
		
		while (true) {
			if (bitCount == Integer.bitCount(nextNumber)) {
				break;
			}
			
			nextNumber++;
		}
		
		return nextNumber;
	}
}