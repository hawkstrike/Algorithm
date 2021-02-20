package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/roman-to-integer/
public class Roman_to_Integer {
	public static void main(String[] args) {
		//String s = "III";
		//String s = "IV";
		//String s = "IX";
		//String s = "LVIII";
		String s = "MCMXCIV";
		
		System.out.println(romanToInt(s));
	}
	
	public static int romanToInt(String s) {
		HashMap<Character, Integer> hashMap = new HashMap<>();
		char[] arr = s.toCharArray();
		int length = arr.length;
		int result = 0;
		
		hashMap.put('I', 1);
		hashMap.put('V', 5);
		hashMap.put('X', 10);
		hashMap.put('L', 50);
		hashMap.put('C', 100);
		hashMap.put('D', 500);
		hashMap.put('M', 1000);
		
		for (int i = 0; i < length; i++) {
			if (i > 0 && (hashMap.get(arr[i]) > hashMap.get(arr[i - 1]))) {
				result += hashMap.get(arr[i]) - (hashMap.get(arr[i - 1]) * 2);
			} else {
				result += hashMap.get(arr[i]);
			}
		}
		
		return result;
	}
}