package Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.List;

// 기능개발
// https://programmers.co.kr/learn/courses/30/lessons/42586
public class Problem_42586 {
	
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		/*int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};*/
		int[] result = solution(progresses, speeds);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> resultList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int length = progresses.length;
		
		for (int i = 0; i < length; i++) {
			int time = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
			
			list.add(time);
		}
		
		int curr = 0;
		int count = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (curr < list.get(i)) {
				if (count != 0) {
					resultList.add(count);
				}
				
				count = 1;
				curr = list.get(i);
			} else {
				count++;
			}
		}
		
		if (count != 0) {
			resultList.add(count);
		}
		
		return resultList.stream().mapToInt(Integer::intValue).toArray();
	}
}