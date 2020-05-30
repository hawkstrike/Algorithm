package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class K_Closest_Points_to_Origin {
	public static void main(String[] args) {
		/*int[][] points = {{1, 3},
						{-2, 2}};
		int K = 1;*/
		/*int[][] points = {{3, 3},
						{5, -1},
						{-2, 4}};
		int K = 2;*/
		int[][] points = {{0, 1},
						{1, 0}};
		int K = 2;
		int[][] result = kClosest(points, K);
		
		for (int[] arr : result) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}
	
	public static int[][] kClosest(int[][] points, int K) {
		ArrayList<Integer> list = new ArrayList<>();
		int[][] result = new int[K][2];
		
		for (int[] pointArr : points) {
			list.add((pointArr[0] * pointArr[0]) + (pointArr[1] * pointArr[1]));
		}
		
		Collections.sort(list);
		
		int maxDistance = list.get(K - 1);
		int index = 0;
		
		for (int[] pointArr : points) {
			if ((pointArr[0] * pointArr[0]) + (pointArr[1] * pointArr[1]) <= maxDistance) {
				result[index++] = pointArr;
			}
		}
		
		return result;
	}
}