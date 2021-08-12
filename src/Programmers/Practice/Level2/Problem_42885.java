package Programmers.Practice.Level2;

import java.util.Arrays;

// 구명보트
// https://programmers.co.kr/learn/courses/30/lessons/42885
public class Problem_42885 {
	
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		/*int[] people = {70, 80, 50};
		int limit = 100;*/
		
		System.out.println(solution(people, limit));
	}
	
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		
		int left = 0;
		int right = people.length - 1;
		int count = 0;
		
		while (left <= right) {
			int weight = people[left] + people[right];
			
			if (weight > limit) {
				right--;
			} else {
				left++;
				right--;
			}
			
			count++;
		}
		
		return count;
	}
}