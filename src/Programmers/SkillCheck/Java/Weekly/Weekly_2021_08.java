package Programmers.SkillCheck.Java.Weekly;

import java.util.*;

public class Weekly_2021_08 {
	public static void main(String[] args) {
		/*int[][] scores = {{100, 90, 98, 88, 65},
						{50, 45, 99, 85, 77},
						{47, 88, 95, 80, 67},
						{61, 57, 100, 80, 65},
						{24, 90, 94, 75, 65}};*/
		int[][] scores = {{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0}};
		
		System.out.println(solution(scores));
	}
	
	public static String solution(int[][] scores) {
		List<Double> averageList = new ArrayList<>();
		int n = scores.length;
		int m = scores[0].length;
		
		for (int i = 0; i < m; i++) {
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			List<Integer> list = new ArrayList<>();
			int self = 0;
			int sum = 0;
			
			for (int j = 0; j < n; j++) {
				if (i == j) {
					self = scores[j][i];
				}
				
				sum += scores[j][i];
				hashMap.put(scores[j][i], hashMap.getOrDefault(scores[j][i], 0) + 1);
				list.add(scores[j][i]);
			}
			
			int max = Collections.max(list);
			int min = Collections.min(list);
			int count = hashMap.get(self);
			double average = 0;
			
			if ((max == self || min == self) && count == 1) {
				sum -= self;
				list.remove(list.indexOf(self));
			}
			
			average = Math.round(sum / list.size());
			averageList.add(average);
		}
		
		String answer = grade(averageList);
		
		return answer;
	}
	
	
	
	public static String grade(List<Double> averageList) {
		StringBuffer sb = new StringBuffer();
		
		for (double average : averageList) {
			if (average >= 90) {
				sb.append("A");
			} else if (average >= 80 && average < 90) {
				sb.append("B");
			} else if (average >= 70 && average < 80) {
				sb.append("C");
			} else if (average >= 50 && average < 70) {
				sb.append("D");
			} else {
				sb.append("F");
			}
		}
		
		return sb.toString();
	}
}