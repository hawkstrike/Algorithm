package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/check-array-formation-through-concatenation/
public class Check_Array_Formation_Through_Concatenation {
	public static void main(String[] args) {
		int[] arr = {85};
		int[][] pieces = {{85}};
		
		System.out.println(canFormArray(arr, pieces));
	}
	
	public static boolean canFormArray(int[] arr, int[][] pieces) {
		HashMap<Integer, int[]> hashMap = new HashMap<>();
		
		for (int[] piece : pieces) {
			hashMap.put(piece[0], piece);
		}
		
		int start = 0;
		
		while (start < arr.length) {
			if (hashMap.containsKey(arr[start])) {
				int[] piece = hashMap.get(arr[start]);
				
				for (int i = 0; i < piece.length; i++) {
					if (arr[start] != piece[i]) {
						return false;
					} else {
						start++;
					}
				}
			} else {
				return false;
			}
		}
		
		return true;
	}
}