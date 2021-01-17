package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/add-digits/
public class Count_Sorted_Vowel_Strings {
	public static void main(String[] args) {
		int n = 6;
		
		System.out.println(countVowelStrings(n));
	}
	
	// 1 : 5
	// 2 : 15
	// 3 : 35
	// 4 : 70
	// 5 : 126
	// 6 : 210
	public static int countVowelStrings(int n) {
		int a = 1;
		int e = 1;
		int i = 1;
		int o = 1;
		int u = 1;
		
		while (n > 1) {
			a += e + i + o + u;
			e += i + o + u;
			i += o + u;
			o += u;
			
			n--;
		}
		
		return a + e + i + o + u;
	}
}