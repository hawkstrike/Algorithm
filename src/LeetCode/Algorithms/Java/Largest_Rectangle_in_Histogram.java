package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class Largest_Rectangle_in_Histogram {
	public static void main(String[] args) {
		int[] heights = {2, 1, 5, 6, 2, 3};
		
		System.out.println(largestRectangleArea(heights));
	}
	
	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		
		int length = heights.length;
		int[] leftArr = new int[length];
		int[] rightArr = new int[length];
		
		leftArr[0] = -1;
		rightArr[length - 1] = length;
		
		for (int i = 1; i < length; i++) {
			int p = i - 1;
			
			while (p >= 0 && heights[p] >= heights[i]) {
				p = leftArr[p];
			}
			
			leftArr[i] = p;
		}
		
		for (int i = length - 2; i >= 0; i--) {
			int p = i + 1;
			
			while (p < length && heights[p] >= heights[i]) {
				p = rightArr[p];
			}
			
			rightArr[i] = p;
		}
		
		int maxArea = 0;
		for (int i = 0; i < length; i++) {
			maxArea = Math.max(maxArea, heights[i] * (rightArr[i] - leftArr[i] - 1));
		}
		
		return maxArea;
	}
}