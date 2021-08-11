package Programmers.Practice.Level2;

import java.util.LinkedList;
import java.util.Queue;

// 타겟 넘버
// https://programmers.co.kr/learn/courses/30/lessons/43165
public class Problem_43165 {
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		//System.out.println(solution(numbers, target));
		System.out.println(dfs(numbers, target, 0, 0));
	}
	
	public static int solution(int[] numbers, int target) {
		Queue<Integer> queue = new LinkedList<>();
		int length = numbers.length;
		int index = 0;
		int size = 0;
		int count = 0;
		
		queue.offer(numbers[index]);
		queue.offer(-numbers[index]);
		
		size = queue.size();
		index++;
		
		while (!queue.isEmpty() && index <= length) {
			int curr = queue.poll();
			
			if (curr == target && index == length) {
				count++;
			}
			
			if (index == length) {
				continue;
			}
			
			queue.offer(numbers[index] + curr);
			queue.offer(-numbers[index] + curr);
			
			size--;
			
			if (size == 0) {
				size = queue.size();
				index++;
			}
		}
		
		return count;
	}
	
	public static int dfs(int[] numbers, int target, int index, int curr) {
		if (numbers.length == index) {
			return (target == curr) ? 1 : 0;
		}
		
		return dfs(numbers, target, index + 1, numbers[index] + curr) + dfs(numbers, target, index + 1, -numbers[index] + curr);
	}
}