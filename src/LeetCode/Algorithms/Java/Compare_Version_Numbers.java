package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/compare-version-numbers/
public class Compare_Version_Numbers {
	public static void main(String[] args) {
		/*String version1 = "0.1";
		String version2 = "1.1";*/
		/*String version1 = "1.0.1";
		String version2 = "1";*/
		String version1 = "7.5.2.4";
		String version2 = "7.5.3";
		
		System.out.println(compareVersion(version1, version2));
	}
	
	public static int compareVersion(String version1, String version2) {
		String[] version1Arr = version1.split("\\.");
		String[] version2Arr = version2.split("\\.");
		int i = 0;
		int j = 0;
		
		while (i < version1Arr.length || j < version2Arr.length) {
			int x = 0;
			int y = 0;
			
			if (i < version1Arr.length) {
				x = Integer.parseInt(version1Arr[i++]);
			}
			
			if (j < version2Arr.length) {
				y = Integer.parseInt(version2Arr[j++]);
			}
			
			if (x > y) {
				return 1;
			} else if (x < y) {
				return -1;
			}
		}
		
		return 0;
	}
}