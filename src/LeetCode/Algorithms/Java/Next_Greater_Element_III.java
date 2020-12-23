package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/next-greater-element-iii/
public class Next_Greater_Element_III {
	public static void main(String[] args) {
		//int n = 12;
		int n = 21;
		
		System.out.println(nextGreaterElement(n));
	}
	
	public static int nextGreaterElement(int n) {
		char[] arr = (n + "").toCharArray();
		int i;
		int j;
		
		for (i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				break;
			}
		}
		
		if (i == 0) {
			return -1;
		}
		
		int x = arr[i - 1];
		int small = i;
		
		for (j = i + 1; j < arr.length; j++) {
			if (arr[j] > x && arr[j] <= arr[small]) {
				small = j;
			}
		}
		
		char temp = arr[i - 1];
		arr[i - 1] = arr[small];
		arr[small] = temp;
		
		Arrays.sort(arr, i, arr.length);
		
		long value = Long.parseLong(new String(arr));
		
		return (value > Integer.MAX_VALUE) ? -1 : (int) value;
	}
}