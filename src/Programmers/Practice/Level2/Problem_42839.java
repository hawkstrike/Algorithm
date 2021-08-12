package Programmers.Practice.Level2;

import java.util.HashSet;

// 소수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/42839
public class Problem_42839 {
	public static void main(String[] args) {
		String numbers = "17";
		//String numbers = "011";
		
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
		HashSet<Integer> hashSet = new HashSet<>();
		boolean[] visited = new boolean[7];
		
		dfs(hashSet, visited, numbers, "");
		
		System.out.println(hashSet);
		
		return hashSet.size();
	}
	
	public static void dfs(HashSet<Integer> hashSet, boolean[] visited, String numbers, String input) {
		if (!"".equals(input)) {
			int inputNumber = Integer.parseInt(input);
			
			if (!hashSet.contains(inputNumber) && checkPrimaryNumber(inputNumber)) {
				hashSet.add(inputNumber);
			}
		}
		
		for (int i = 0; i < numbers.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(hashSet, visited, numbers, input + numbers.charAt(i));
				visited[i] = false;
			}
		}
	}
	
	public static boolean checkPrimaryNumber(int number) {
		int[] arr = {2, 3, 5, 7};
		int portion = 1;
		
		for (int i = 0; i < arr.length; i++) {
			if (number > arr[i] && number % arr[i] == 0) {
				return false;
			}
		}
		
		for (int i = 2; i <= number; i++) {
			if (number % i == 0) {
				portion++;
			}
		}
		
		return (portion == 2) ? true : false;
	}
}