package Programmers.Practice.Level2;

import java.util.Arrays;

// 최솟값 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12941
public class Problem_12941 {
	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		/*int[] A = {1, 2};
		int[] B = {3, 4};*/
		
		System.out.println(solution(A, B));
	}
	
	public static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[B.length - i - 1];
		}
		
		return sum;
	}
}