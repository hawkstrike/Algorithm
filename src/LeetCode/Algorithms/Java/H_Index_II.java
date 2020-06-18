package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/h-index-ii/
public class H_Index_II {
	public static void main(String[] args) {
		int[] citations = {0, 1, 3, 5, 6};
		
		System.out.println(hIndex(citations));
	}
	
	public static int hIndex(int[] citations) {
		int result = 0;
		int left = 0;
		int right = citations.length - 1;
		int length = citations.length;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (citations[mid] >= (length - mid)) {
				result = (length - mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}
}