package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/valid-square/
public class Valid_Square {
	public static void main(String[] args) {
		int[] p1 = {0, 0};
		int[] p2 = {1, 1};
		int[] p3 = {1, 0};
		int[] p4 = {0, 1};
		
		System.out.println(validSquare(p1, p2, p3, p4));
	}
	
	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] p = {p1, p2, p3, p4};
		
		Arrays.sort(p, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
		
		return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0]) && dist(p[0], p[3]) == dist(p[1], p[2]);
	}
	
	public static double dist(int[] p1, int[] p2) {
		return (p2[1] - p1[1]) * (p2[1] - p1[1]) + ((p2[0] - p1[0]) * (p2[0] - p1[0]));
	}
}