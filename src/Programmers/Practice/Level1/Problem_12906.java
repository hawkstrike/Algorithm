package Programmers.Practice.Level1;

import java.util.LinkedList;
import java.util.List;

// 같은 숫자는 싫어
// https://programmers.co.kr/learn/courses/30/lessons/12906
public class Problem_12906 {
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		int[] result = solution(arr);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int[] arr) {
		List<Integer> list = new LinkedList<>();
		int length = arr.length;
		
		for (int i = 0; i < length; i++) {
			if (list.isEmpty() || list.get(list.size() - 1) != arr[i]) {
				list.add(arr[i]);
			}
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}