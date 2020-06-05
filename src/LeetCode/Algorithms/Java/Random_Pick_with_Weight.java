package LeetCode.Algorithms.Java;

import java.util.Random;

// https://leetcode.com/problems/random-pick-with-weight/
public class Random_Pick_with_Weight {
	public static class Solution {
		Random random;
		int[] w;
		
		public Solution(int[] w) {
			random = new Random();
			this.w = new int[w.length];
			
			for (int i = 1; i < w.length; i++) {
				this.w[i] = this.w[i - 1] + w[i];
			}
		}
		
		public int pickIndex() {
			int left = 0;
			int right = this.w.length - 1;
			int target = random.nextInt(this.w[right]) + 1;
			
			while (left < right) {
				int mid = left + (right - left) / 2;
				
				if (this.w[mid] == target) {
					return mid;
				} else if (this.w[mid] < target) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			
			return left;
		}
	}
	public static void main(String[] args) {
	
	}
}