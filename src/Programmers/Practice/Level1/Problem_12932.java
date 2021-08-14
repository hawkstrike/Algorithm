package Programmers.Practice.Level1;

import java.util.ArrayList;
import java.util.List;

// 자연수 뒤집어 배열로 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12932
public class Problem_12932 {
	
	public static void main(String[] args) {
		//long n = 12345;
		long n = 12340;
		int[] result = solution(n);
		
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(long n) {
		StringBuffer reverseNumber = new StringBuffer(Long.toString(n)).reverse();
		//long reverse = Long.parseLong(reverseNumber.toString());
		//char[] arr = Long.toString(reverse).toCharArray();
		char[] arr = reverseNumber.toString().toCharArray();
		List<Integer> list = new ArrayList<>();
		
		for (int i : arr) {
			list.add(i - 48);
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}