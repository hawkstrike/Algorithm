package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
public class Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
	public static void main(String[] args) {
		String s = "00110110";
		int k = 2;
		
		System.out.println(hasAllCodes(s, k));
	}
	
	public static boolean hasAllCodes(String s, int k) {
		HashSet<String> hashSet = new HashSet<>();
		int need = 1 << k;
		
		for (int i = k; i <= s.length(); i++) {
			String str = s.substring(i - k, i);
			
			if (!hashSet.contains(str)) {
				hashSet.add(str);
				need--;
				
				if (need == 0) {
					return true;
				}
			}
		}
		
		return false;
	}
}