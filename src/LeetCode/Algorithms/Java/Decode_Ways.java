package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/decode-ways/
public class Decode_Ways {
	public static void main(String[] args) {
		String s = "12";
		
		System.out.println(numDecodings(s));
	}
	
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		
		int[] dp = new int[s.length() + 1];
		
		dp[0] = 1;
		dp[1] = (s.charAt(0) == '0') ? 0 : 1;
		
		for (int i = 2; i < dp.length; i++) {
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			
			int nextNumber = Integer.parseInt(s.substring(i - 2, i));
			
			if (nextNumber >= 10 && nextNumber <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		
		return dp[s.length()];
		
		/*if (s == null || s.length() == 0) {
			return 0;
		}
		
		int[] cache = new int[s.length() + 1];
		
		return recurrentNumDecodings(s, 0, cache);*/
	}
	
	public static int recurrentNumDecodings(String s, int index, int[] cache) {
		if (index == s.length()) {
			return 1;
		}
		
		if (s.charAt(index) == '0') {
			return 0;
		}
		
		if (index == s.length() - 1) {
			return 1;
		}
		
		if (cache[index] > 0) {
			return cache[index];
		}
		
		int result = recurrentNumDecodings(s, index + 1, cache);
		
		if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
			result += recurrentNumDecodings(s, index + 2, cache);
		}
		
		cache[index] = result;
		
		return result;
	}
}