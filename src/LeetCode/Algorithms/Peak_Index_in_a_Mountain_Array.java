package LeetCode.Algorithms;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class Peak_Index_in_a_Mountain_Array {
	public static void main(String[] args){
		int[] A = {0, 2, 1, 0}; // {0, 2, 1, 0}; // {0, 1, 0};

		System.out.println(peakIndexInMountainArray(A));
	}
	
	/*public static int peakIndexInMountainArray(int[] A) {
		int max = 0;
		int index = A.length - 1;
		
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				if (max < A[i]) {
					max = A[i];
					index = i;
				}
			}
		}
		
		return index;
	}*/
	
	public static int peakIndexInMountainArray(int[] A) {
		int left = 0;
		int right = A.length - 1;
		
		while (left < right) {
			int middle = left + (right - left) / 2;
			
			if (A[middle] < A[middle + 1]) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		
		return left;
	}
}