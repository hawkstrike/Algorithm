package Programmers.Practice.Level1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

// 제일 작은 수 제거하기
// https://programmers.co.kr/learn/courses/30/lessons/12935
public class Problem_12935 {
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
		int[] result = solution(arr);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		int length = arr.length;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < length; i++) {
			list.add(arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		list.remove((Integer) min);
		
		if (list.isEmpty()) {
			list.add(-1);
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
		
		/*LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		int length = arr.length;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < length; i++) {
			linkedHashSet.add(arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		linkedHashSet.remove(min);
		
		if (linkedHashSet.isEmpty()) {
			linkedHashSet.add(-1);
		}
		
		return linkedHashSet.stream().mapToInt(Integer::intValue).toArray();*/
	}
}