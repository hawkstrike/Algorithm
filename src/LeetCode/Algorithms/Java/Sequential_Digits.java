package LeetCode.Algorithms.Java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/sequential-digits/
public class Sequential_Digits {
	public static void main(String[] args) {
		int low = 100;
		int high = 300;
		List<Integer> result = sequentialDigits(low, high);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
	}
	
	public static List<Integer> sequentialDigits(int low, int high) {
		List<Integer> result = new LinkedList<>();
		
		for (int i = 1; i <= 9; i++) {
			backtrackingSequentialDigits(result, low, high, 0, i);
		}
		
		Collections.sort(result);
		
		return result;
	}
	
	public static void backtrackingSequentialDigits(List<Integer> list, int low, int high, int value, int n) {
		if (value > high) {
			return;
		}
		
		if (value >= low) {
			list.add(value);
		}
		
		if (n > 9) {
			return;
		}
		
		backtrackingSequentialDigits(list, low, high, value * 10 + n, n + 1);
	}
}