package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/numbers-with-same-consecutive-differences/
public class Numbers_With_Same_Consecutive_Differences {
	public static void main(String[] args) {
		int N = 3;
		int K = 7;
		int[] result = numsSameConsecDiff(N, K);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		
		System.out.println();
	}
	
	public static int[] numsSameConsecDiff(int N, int K) {
		if (N == 1) {
			return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		}
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		for (int level = 1; level < N; level++) {
			ArrayList<Integer> nextList = new ArrayList<>();
			
			for (Integer num : list) {
				Integer finalNumber = num % 10;
				
				ArrayList<Integer> nextNumberList = new ArrayList<>();
				
				nextNumberList.add(finalNumber + K);
				
				if (K != 0) {
					nextNumberList.add(finalNumber - K);
				}
				
				for (Integer nextNumber : nextNumberList) {
					if (nextNumber >= 0 && nextNumber < 10) {
						Integer resultNumber = num * 10 + nextNumber;
						
						nextList.add(resultNumber);
					}
				}
			}
			
			list = nextList;
		}
		
		return list.stream().mapToInt(i -> i).toArray();
	}
}