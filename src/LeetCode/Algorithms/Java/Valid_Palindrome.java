package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/valid-palindrome/
public class Valid_Palindrome {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		/*String lowerCaseStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String compareStr = new StringBuffer(lowerCaseStr).reverse().toString();
		
		return lowerCaseStr.equals(compareStr);*/
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			} else if (!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			} else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		
		return true;
	}
}