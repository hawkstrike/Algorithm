package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/flood-fill/
public class Flood_Fill {
	public static class Pair {
		int first;
		int second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public int getFirst() {
			return this.first;
		}
		
		public int getSecond() {
			return this.second;
		}
	}
	
	public static void main(String[] args) {
		/*int[][] image = {{1, 1, 1},
						{1, 1, 0},
						{1, 0, 1}};*/
		int[][] image = {{0, 0, 0}, {0, 1, 0}};
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		
		int[][] result = floodFill(image, sr, sc, newColor);
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		Queue<Pair> q = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int oldColor = image[sr][sc];
		
		if (oldColor == newColor) {
			return image;
		}
		
		q.offer(new Pair(sr, sc));
		image[sr][sc] = newColor;
		
		while (!q.isEmpty()) {
			Pair coor = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int currX = coor.getFirst() + dx[i];
				int currY = coor.getSecond() + dy[i];
				
				if (currX >= 0 && currY >= 0 && currX < image.length && currY < image[0].length && image[currX][currY] == oldColor) {
					q.offer(new Pair(currX, currY));
					image[currX][currY] = newColor;
				}
			}
		}
		
		return image;
	}
}