package LeetCode.Algorithms.Java;

import java.util.Random;
import java.util.TreeMap;

// https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
public class Random_Point_in_Non_overlapping_Rectangles {
	public static class Solution {
		private TreeMap<Integer, Integer> treeMap;
		private Random random;
		private int[][] rects;
		private int area;
		
		public Solution(int[][] rects) {
			this.treeMap = new TreeMap<>();
			this.random = new Random();
			this.rects = rects;
			this.area = 0;
			
			for (int i = 0; i < rects.length; i++) {
				this.area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
				this.treeMap.put(this.area, i);
			}
		}
		
		public int[] pick() {
			int randomInt = this.random.nextInt(this.area);
			int key = this.treeMap.higherKey(randomInt);
			int[] rect = this.rects[treeMap.get(key)];
			int x = rect[0] + (key - randomInt - 1) % (rect[2] - rect[0] + 1);
			int y = rect[1] + (key - randomInt - 1) / (rect[2] - rect[0] + 1);
			
			return new int[]{x, y};
		}
	}
	
	public static void main(String[] args) {
		int[][] rects = {{1, 1, 5, 5}};
		Solution solution = new Solution(rects);
		
		printf(solution.pick());
		printf(solution.pick());
		printf(solution.pick());
	}
	
	public static void printf(int[] pick) {
		for (int n : pick) {
			System.out.print(n + " ");
		}
		
		System.out.println();
	}
}