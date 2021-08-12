package Programmers.Practice.Level2;

import java.util.*;

// 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587
public class Problem_42587 {
	
	public static void main(String[] args) {
		/*int[] priorities = {2, 1, 3, 2};
		int location = 2;*/
		/*int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;*/
		int[] priorities = {2, 1, 2, 1, 2};
		int location = 1;
		
		System.out.println(solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
		Deque<coor> deque = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		int target = priorities[location];
		int count = 1;
		int index = 0;
		
		for (int i = 0; i < priorities.length; i++) {
			deque.offer(new coor(i, priorities[i]));
			list.add(priorities[i]);
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		while (!deque.isEmpty()) {
			coor c = deque.poll();
			
			if (c.index == location && c.value == target && c.value == list.get(index)) {
				return count;
			}
			
			if (c.value < list.get(index)) {
				deque.offer(c);
			} else {
				count++;
				
				if (c.value == list.get(index)) {
					index++;
				}
			}
		}
		
		return count;
	}
	
	public static class coor {
		int index;
		int value;
		
		public coor(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}