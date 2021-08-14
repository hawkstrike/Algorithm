package Programmers.Practice.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 나누어 떨어지는 숫자 배열
// https://programmers.co.kr/learn/courses/30/lessons/12910
public class Problem_12910 {
	
	public static void main(String[] args) {
		/*int[] arr = {5, 9, 7, 10};
		int divisor = 5;*/
		/*int[] arr = {2, 36, 1, 3};
		int divisor = 1;*/
		int[] arr = {3, 2, 6};
		int divisor = 10;
		int[] result = solution(arr, divisor);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		
		for (int n : arr) {
			if (n % divisor == 0) {
				list.add(n);
			}
		}
		
		if (list.isEmpty()) {
			list.add(-1);
		} else {
			Collections.sort(list);
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}