package Programmers.Practice.Level2;

import java.util.Arrays;

// N개의 최소공배수
// https://programmers.co.kr/learn/courses/30/lessons/12953
public class Problem_12953 {
	
	public static void main(String[] args) {
		//int[] arr = {2, 6, 8, 14};
		int[] arr = {1, 2, 3};
		
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] arr) {
		Arrays.sort(arr);
		
		int minimum = 0;
		int currNumber = arr[arr.length - 1];
		
		while (true) {
			boolean flag = true;
			
			for (int n : arr) {
				if (currNumber % n != 0) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				minimum = currNumber;
				break;
			}
			
			currNumber++;
		}
		
		return minimum;
	}
}