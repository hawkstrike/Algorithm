package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/
public class Letter_Case_Permutation {
	public static void main(String[] args) {
		String S = "a1b2";
		List<String> result = letterCasePermutation(S);
		
		for (String str : result) {
			System.out.println(str);
		}
	}
	
	public static List<String> letterCasePermutation(String S) {
		List<String> list = new LinkedList<>();
		char[] arr = S.toCharArray();
		
		recurrentLetterCasePermutation(list, arr, 0);
		
		return list;
	}
	
	public static void recurrentLetterCasePermutation(List<String> list, char[] arr, int index) {
		list.add(new String(arr));
		
		for (int i = index; i < arr.length; i++) {
			char c = arr[i];
			
			if (Character.isLetter(c)) {
				arr[i] = (Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c);
				recurrentLetterCasePermutation(list, arr, i + 1);
				arr[i] = c;
			}
		}
	}
}