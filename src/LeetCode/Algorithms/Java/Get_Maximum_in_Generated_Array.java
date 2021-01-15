package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/get-maximum-in-generated-array/
public class Get_Maximum_in_Generated_Array {
	public static void main(String[] args) {
		//int n = 7;
		//int n = 2;
		int n = 3;
		
		System.out.println(getMaximumGenerated(n));
	}
	
	public static int getMaximumGenerated(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		
		int[] arr = new int[n + 1];
		int max = Integer.MIN_VALUE;
		
		arr[1] = 1;
		
		for (int i = 2; i < arr.length; i++) {
			int num = 0;
			
			if (i % 2 == 0) {
				num = arr[i / 2];
			} else {
				num = arr[i / 2] + arr[i - (i / 2)];
			}
			
			arr[i] = num;
			max = Math.max(max, num);
		}
		
		return max;
	}
}