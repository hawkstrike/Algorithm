package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/goat-latin/
public class Goat_Latin {
	public static void main(String[] args) {
		//String S = "I speak Goat Latin";
		String S = "The quick brown fox jumped over the lazy dog";
		
		System.out.println(toGoatLatin(S));
	}
	
	public static String toGoatLatin(String S) {
		StringBuffer result = new StringBuffer();
		String[] sArr = S.split(" ");
		int index = 1;
		
		for (int i = 0; i < sArr.length; i++) {
			StringBuffer sb = new StringBuffer(sArr[i]);
			String startStr = sb.substring(0, 1).toLowerCase();
			
			if (startStr.indexOf("a") == 0 || startStr.indexOf("e") == 0 || startStr.indexOf("i") == 0 || startStr.indexOf("o") == 0 || startStr.indexOf("u") == 0) {
				sb.append("ma");
			} else {
				char c = sb.charAt(0);
				
				sb = sb.deleteCharAt(0);
				sb.append(c).append("ma");
			}
			
			for (int j = 0; j < index; j++) {
				sb.append("a");
			}
			
			index++;
			result.append(sb.toString()).append(" ");
		}
		
		return result.toString().trim();
	}
}