package Programmers.Practice.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// K번째수
// https://programmers.co.kr/learn/courses/30/lessons/42748
public class Problem_42748 {
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},
							{4, 4, 1},
							{1, 7, 3}};
		int[] result = solution(array, commands);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		List<Integer> list = new ArrayList<>();
		
		for (int[] command : commands) {
			int length = command[1] - command[0] + 1;
			int[] arr = new int[length];
			int index = 0;
			
			for (int i = command[0] - 1; i < command[1]; i++) {
				arr[index++] = array[i];
			}
			
			Arrays.sort(arr);
			
			list.add(arr[command[2] - 1]);
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}