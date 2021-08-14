package Programmers.Practice.Level1;

// x만큼 간격이 있는 n개의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12954
public class Problem_12954 {
	
	public static void main(String[] args) {
		/*int x = 2;
		int n = 5;*/
		/*int x = 4;
		int n = 3;*/
		/*int x = -4;
		int n = 2;*/
		long x = 10000000;
		int n = 1000;
		long[] result = solution(x, n);
		
		for (long num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static long[] solution(long x, int n) {
		long[] arr = new long[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = x + (x * i);
		}
		
		return arr;
	}
}