package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/pancake-sorting/
public class Pancake_Sorting {
	public static void main(String[] args) {
		int[] A = {3, 2, 4, 1};
		List<Integer> result = pancakeSort(A);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new LinkedList<>();
		
		for (int i = A.length; i > 0; i--) {
			int index = find(A, i);
			
			if (index == i - 1) {
				continue;
			}
			
			if (index != 0) {
				list.add(index + 1);
				flip(A, index + 1);
			}
			
			list.add(i);
			flip(A, i);
		}
		
		return list;
	}
	
	private static void flip(int[] subArr, int k) {
		int i = 0;
		
		while (i < k / 2) {
			int temp = subArr[i];
			subArr[i] = subArr[k - i - 1];
			subArr[k - i - 1] = temp;
			
			i++;
		}
	}
	
	private static int find(int[] A, int target) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return i;
			}
		}
		
		return -1;
	}
}