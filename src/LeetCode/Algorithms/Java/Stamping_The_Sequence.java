package LeetCode.Algorithms.Java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/stamping-the-sequence/
public class Stamping_The_Sequence {
	public static void main(String[] args) {
		String stamp = "abc";
		String target = "ababc";
		int[] result = movesToStamp(stamp, target);
		
		for (int n : result) {
			System.out.println(n);
		}
	}
	
	public static int[] movesToStamp(String stamp, String target) {
		List<Integer> result = new LinkedList<>();
		char[] stampArr = stamp.toCharArray();
		char[] targetArr = target.toCharArray();
		int stampLength = stamp.length();
		int targetLength = target.length();
		boolean changed = true;
		
		while (changed) {
			changed = false;
			
			for (int i = 0; i < targetLength - stampLength + 1; i++) {
				changed |= check(result, stampArr, targetArr, i);
			}
		}
		
		for (int c : targetArr) {
			if (c != '?') {
				return new int[]{};
			}
		}
		
		Collections.reverse(result);
		
		return result.stream().mapToInt(i -> i).toArray();
	}
	
	public static boolean check(List<Integer> result, char[] stampArr, char[] targetArr, int index) {
		boolean changed = false;
		
		for (int i = 0; i < stampArr.length; i++) {
			if (targetArr[index + i] == '?') {
				continue;
			}
			
			if (targetArr[index + i] != stampArr[i]) {
				return false;
			}
			
			changed = true;
		}
		
		if (changed) {
			for (int i = 0; i < stampArr.length; i++) {
				targetArr[index + i] = '?';
			}
			
			result.add(index);
		}
		
		return changed;
	}
}