package Programmers.Practice.Level1;

import java.util.stream.IntStream;

// 모의고사
// https://programmers.co.kr/learn/courses/30/lessons/42840
public class Problem_42840 {
	
	public static void main(String[] args) {
		//int[] answer = {1, 2, 3, 4, 5};
		int[] answer = {1, 3, 2, 4, 2};
		int[] result = solution(answer);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int[] answers) {
		int[] person1st = {1, 2, 3, 4, 5};
		int[] person2nd = {1, 3, 4, 5};
		int[] person3rd = {3, 1, 2, 4, 5};
		int[] score = new int[3];
		int length = answers.length;
		int index = 0;
		
		for (int i = 0; i < length; i++) {
			int answer1st = (i % 5) + 1;
			int answer2nd = ((i + 1) % 2 == 1) ? 2 : person2nd[index % 4];
			int answer3rd = person3rd[index % 5];
			
			if (answers[i] == answer1st) {
				score[0]++;
			}
			
			if (answers[i] == answer2nd) {
				score[1]++;
			}
			
			if (answers[i] == answer3rd) {
				score[2]++;
			}
			
			if ((i + 1) % 2 == 0) {
				index++;
			}
		}
		
		int max = Math.max(score[0], Math.max(score[1], score[2]));
		int finalMax = max;
		
		return IntStream.range(1, score.length + 1)
				.filter(i -> score[i - 1] == finalMax)
				.toArray();
	}
}