package Programmers.Practice.Level2;

import java.util.TreeSet;

// 이중우선순위큐
// https://programmers.co.kr/learn/courses/30/lessons/42628
public class Problem_42628 {
	
	public static void main(String[] args) {
		//String[] operations = {"I 16", "D 1"};
		String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		int[] result = solution(operations);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(String[] operations) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		int[] result = new int[2];
		
		for (String oper : operations) {
			String[] command = oper.split(" ");
			
			if ("I".equals(command[0])) {
				treeSet.add(Integer.parseInt(command[1]));
			} else if ("D".equals(command[0]) && !treeSet.isEmpty()) {
				if ("1".equals(command[1])) {
					treeSet.pollLast();
				} else if ("-1".equals(command[1])) {
					treeSet.pollFirst();
				}
			}
		}
		
		if (!treeSet.isEmpty()) {
			result[0] = treeSet.last();
			result[1] = treeSet.first();
		}
		
		return result;
	}
}