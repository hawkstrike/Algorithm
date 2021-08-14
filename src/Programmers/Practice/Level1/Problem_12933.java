package Programmers.Practice.Level1;

import java.util.Arrays;

// 정수 내림차순으로 배치하기
// https://programmers.co.kr/learn/courses/30/lessons/12933
public class Problem_12933 {
	
	public static void main(String[] args) {
		long n = 118372;
		
		System.out.println(solution(n));
	}
	
	public static long solution(long n) {
		StringBuffer sb = new StringBuffer();
		char[] arr = Long.toString(n).toCharArray();
		
		Arrays.sort(arr);
		
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i] - 48);
		}
		
		return Long.parseLong(sb.toString());
	}
}