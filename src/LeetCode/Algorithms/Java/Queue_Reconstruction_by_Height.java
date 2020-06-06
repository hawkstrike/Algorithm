package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/queue-reconstruction-by-height/
public class Queue_Reconstruction_by_Height {
	public static void main(String[] args) {
		int[][] people = {{7, 0},
						{4, 4},
						{7, 1},
						{5, 0},
						{6, 1},
						{5, 2}};
		int[][] result = reconstructQueue(people);
		
		for (int[] p : result) {
			System.out.println(p[0] + " " + p[1]);
		}
	}
	
	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (p1, p2) -> {
			return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
		});
		
		List<int[]> list = new ArrayList<>();
		
		for (int i = 0; i < people.length; i++) {
			list.add(people[i][1], people[i]);
		}
		
		return list.toArray(people);
	}
}