package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/create-sorted-array-through-instructions/
public class Create_Sorted_Array_through_Instructions {
	static int[] arr;
	
	public static void main(String[] args) {
		//int[] instructions = {1, 5, 6, 2};
		int[] instructions = {4, 14, 10, 2, 5, 3, 8, 19, 7, 20, 12, 1, 9, 15, 13, 11, 18, 6, 16, 17};
		
		System.out.println(createSortedArray(instructions));
	}
	
	public static int createSortedArray(int[] instructions) {
		int result = 0;
		int length = instructions.length;
		int mod = (int)1e9 + 7;
		
		arr = new int[100001];
		
		for (int i = 0; i < length; i++) {
			result = (result + Math.min(get(instructions[i] - 1), i - get(instructions[i]))) % mod;
			update(instructions[i]);
		}
		
		return result;
	}
	
	public static void update(int x) {
		while (x < 100001) {
			arr[x]++;
			x += x & -x;
		}
	}
	
	public static int get(int x) {
		int result = 0;
		
		while (x > 0) {
			result += arr[x];
			x -= x & -x;
		}
		
		return result;
	}
}