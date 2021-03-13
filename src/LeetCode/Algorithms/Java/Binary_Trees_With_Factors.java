package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/binary-trees-with-factors/
public class Binary_Trees_With_Factors {
	public static void main(String[] args) {
		int[] arr = {2, 4};
		
		System.out.println(numFactoredBinaryTrees(arr));
	}
	
	public static int numFactoredBinaryTrees(int[] arr) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int mod = 1_000_000_007;
		int length = arr.length;
		long[] dp = new long[length];
		
		Arrays.sort(arr);
		Arrays.fill(dp, 1);
		
		for (int i = 0; i < length; i++) {
			hashMap.put(arr[i], i);
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0) {
					int right = arr[i] / arr[j];
					
					if (hashMap.containsKey(right)) {
						dp[i] = (dp[i] + dp[j] * dp[hashMap.get(right)]) % mod;
					}
				}
			}
		}
		
		long result = 0;
		
		for (long x : dp) {
			result += x;
		}
		
		return (int) (result % mod);
	}
}