package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/longest-mountain-in-array/
public class Longest_Mountain_in_Array {
	public static void main(String[] args) {
		int[] A = {2, 1, 4, 7, 3, 2, 5};
		
		System.out.println(longestMountain(A));
	}
	
	public static int longestMountain(int[] A) {
		int length = A.length;
		int result = 0;
		int base = 0;
		
		while (base < length) {
			int end = base;
			
			if (end + 1 < length && A[end] < A[end + 1]) {
				while (end + 1 < length && A[end] < A[end + 1]) {
					end++;
				}
				
				if (end + 1 < length && A[end] > A[end + 1]) {
					while (end + 1 < length && A[end] > A[end + 1]) {
						end++;
					}
					
					result = Math.max(result, end - base + 1);
				}
			}
			
			base = Math.max(end, base + 1);
		}
		
		return result;
	}
}