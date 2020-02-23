package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/jewels-and-stones/
public class Jewels_and_Stones {
	public static void main(String[] args) {
		String J = "z"; // "aA";
		String S = "ZZ"; // "aAAbbbb";

		System.out.println(numJewelsInStones(J, S));
	}

	public static int numJewelsInStones(String J, String S) {
		int result = 0;

		for (int i = 0; i < J.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (J.charAt(i) == S.charAt(j))
					result++;
			}
		}

		return result;
	}
}