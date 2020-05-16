package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/maximum-sum-circular-subarray/
public class Maximum_Sum_Circular_Subarray {
	public static void main(String[] args) {
//		int[] A = {1, -2, 3, -2};
//		int[] A = {5, -3, 5};
//		int[] A = {3 - 1, 2, -1};
//		int[] A = {3, -2, 2, -3};
		int[] A = {-2};
		
		System.out.println(maxSubarraySumCircular(A));
	}
	
	public static int maxSubarraySumCircular(int[] A) {
		int sum = 0;
		
		for (int n : A) {
			sum += n;
		}
		
		/*int min = kadaneMin(A);
		int max = kadaneMax(A);
		
		if (min == sum) {
			return max;
		}
		
		return Math.max(max, sum - min);*/
		
		int result1 = kadane(A, 0, A.length - 1, 1);
		int result2 = sum + kadane(A, 1, A.length - 1, -1);
		int result3 = sum + kadane(A, 0, A.length - 2, -1);
		
		System.out.println("result1 : " + result1 + " | result2 : " + result2 + " | result3 : " + result3);
		
		return Math.max(result1, Math.max(result2, result3));
	}
	
	/*public static int kadaneMin(int[] A) {
		int min = A[0];
		int sum = A[0];
		
		for (int i = 1; i < A.length; i++) {
			sum = Math.min(A[i], sum + A[i]);
			min = Math.min(sum, min);
		}
		
		return min;
	}
	
	public static int kadaneMax(int[] A) {
		int max = A[0];
		int sum = A[0];
		
		for (int i = 1; i < A.length; i++) {
			sum = Math.max(A[i], sum + A[i]);
			max = Math.max(sum, max);
		}
		
		return max;
	}*/
	
	public static int kadane(int[] A, int i, int j, int sign) {
		long result = Integer.MIN_VALUE;
		long curr = Integer.MIN_VALUE;
		
		for (int k = i; k <= j; k++) {
			curr = sign * A[k] + Math.max(curr, 0);
			result = Math.max(result, curr);
		}
		
		System.out.println("result : " + result + " | curr : " + curr);
		
		return (int) result;
	}
}