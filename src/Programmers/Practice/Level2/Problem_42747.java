package Programmers.Practice.Level2;

import java.util.Arrays;

// H-index
// https://programmers.co.kr/learn/courses/30/lessons/42747
public class Problem_42747 {
	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		Arrays.sort(citations);
		
		int hIndex = 0;
		int left = 0;
		int right = citations.length - 1;
		int length = citations.length;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (citations[mid] >= (length - mid)) {
				hIndex = length - mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return hIndex;
	}
}