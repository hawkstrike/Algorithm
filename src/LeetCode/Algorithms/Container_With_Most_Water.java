package LeetCode.Algorithms;

// https://leetcode.com/problems/container-with-most-water/
public class Container_With_Most_Water {
	public static void main(String[] args){
		int[] height = {1, 1}; // {1, 8, 6, 2, 5, 4, 8, 3, 7};

		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int result = 0;
		int leftIndex = 0;
		int rightIndex = height.length - 1;
		
		while (leftIndex < rightIndex) {
			result = Math.max(result, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
			
			if (height[leftIndex] < height[rightIndex]) {
				leftIndex++;
			} else {
				rightIndex--;
			}
		}
		
		return result;
	}
}