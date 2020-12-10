package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/valid-mountain-array/
public class Valid_Mountain_Array {
	public static void main(String[] args) {
		//int[] arr = {2, 1};
		//int[] arr = {3, 5, 5};
		//int[] arr = {0, 3, 2, 1};
		int[] arr = {2, 0, 2};
		
		System.out.println(validMountainArray(arr));
	}
	
	public static boolean validMountainArray(int[] arr) {
		int length = arr.length;
		int index = 0;
		
		while (index + 1 < length && arr[index] < arr[index + 1]) {
			index++;
		}
		
		if (index == 0 || index == length - 1) {
			return false;
		}
		
		while (index + 1 < length && arr[index] > arr[index + 1]) {
			index++;
		}
		
		return index == length - 1;
	}
}