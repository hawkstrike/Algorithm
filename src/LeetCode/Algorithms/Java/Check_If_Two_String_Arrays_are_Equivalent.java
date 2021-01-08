package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
public class Check_If_Two_String_Arrays_are_Equivalent {
	public static void main(String[] args) {
		String[] word1 = {"ab", "c"};
		String[] word2 = {"a", "bc"};
		
		System.out.println(arrayStringsAreEqual(word1, word2));
	}
	
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		for (String str : word1) {
			sb1.append(str);
		}
		
		for (String str : word2) {
			sb2.append(str);
		}
		
		return sb1.toString().equals(sb2.toString());
	}
}