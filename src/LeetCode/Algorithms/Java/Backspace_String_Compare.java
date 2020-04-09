package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/backspace-string-compare/
public class Backspace_String_Compare {
	public static void main(String[] args) {
		String S = "xywrrmp"; //"a#c"; //"ab#c";
		String T = "xywrrmu#p";//"b";//"ad#c";
		
		System.out.println(backspaceCompare(S, T));
	}
	
	public static boolean backspaceCompare(String S, String T) {
		return (checkString(S).equals(checkString(T)) ? true : false);
	}
	
	public static String checkString(String str) {
		StringBuffer sb = new StringBuffer();
		
		for (Character c : str.toCharArray()) {
			if (c != '#') {
				sb.append(c);
			} else if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		
		return sb.toString();
	}
}