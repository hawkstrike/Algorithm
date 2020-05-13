package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/remove-k-digits/
public class Remove_K_Digits {
	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		
		System.out.println(removeKdigits(num, k));
	}
	
	public static String removeKdigits(String num, int k) {
		StringBuffer sb = new StringBuffer(num);
		
		while (k > 0) {
			for (int i = 0; i < sb.length(); i++) {
				if (i + 1 < sb.length() && sb.charAt(i) > sb.charAt(i + 1)) {
					sb.deleteCharAt(i);
					break;
				} else if (i == sb.length() - 1) {
					sb.deleteCharAt(i);
					break;
				}
			}
			
			k--;
		}
		
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		
		if ("".equals(sb.toString())) {
			return "0";
		} else {
			return sb.toString();
		}
	}
}