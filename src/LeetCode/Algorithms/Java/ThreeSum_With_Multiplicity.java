package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/3sum-with-multiplicity/
public class ThreeSum_With_Multiplicity {
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		int target = 8;
		
		System.out.println(threeSumMulti(arr, target));
	}
	
	public static int threeSumMulti(int[] arr, int target) {
		long[] numberArr = new long[101];
		long result = 0;
		
		for (int n : arr) {
			numberArr[n]++;
		}
		
		for (int i = 0; i <= 100; i++) {
			for (int j = i; j <= 100; j++) {
				int k = target - i - j;
				
				if (k > 100 || k < 0) {
					continue;
				}
				
				if (i == j && j == k) {
					result += numberArr[i] * (numberArr[i] - 1) * (numberArr[i] - 2) / 6;
				} else if (i == j && j != k) {
					result += numberArr[i] * (numberArr[i] - 1) / 2 * numberArr[k];
				} else if (j < k) {
					result += numberArr[i] * numberArr[j] * numberArr[k];
				}
			}
		}
		
		return (int) (result % (1e9 + 7));
	}
}