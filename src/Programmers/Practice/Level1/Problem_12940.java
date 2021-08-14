package Programmers.Practice.Level1;

// 최대공약수와 최소공배수
// https://programmers.co.kr/learn/courses/30/lessons/12940
public class Problem_12940 {
	
	public static void main(String[] args) {
		/*int n = 3;
		int m = 12;*/
		/*int n = 2;
		int m = 5;*/
		int n = 4;
		int m = 12;
		int[] result = solution(n, m);
		
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int n, int m) {
		int maximum = Integer.MIN_VALUE;
		int minimum = 0;
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0 && m % i == 0) {
				maximum = Math.max(maximum, i);
			}
		}
		
		minimum = (n * m) / maximum;
		
		return new int[] {maximum, minimum};
	}
}