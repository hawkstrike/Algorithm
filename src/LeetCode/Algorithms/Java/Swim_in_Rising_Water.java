package LeetCode.Algorithms.Java;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/swim-in-rising-water/
public class Swim_in_Rising_Water {
	public static class coor {
		private int x, y, elevation;

		coor(int x, int y, int elevation) {
			this.x = x;
			this.y = y;
			this.elevation = elevation;
		}
	}

	public static void main(String[] args) {
		int[][] grid = {{0, 2}, {1, 3}};
		/*int[][] grid = {{0, 1, 2, 3, 4},
						{24, 23, 22, 21, 5},
						{12, 13, 14, 15, 16},
						{11, 17, 18, 19, 20},
						{10, 9, 8, 7, 6}};*/
//		int[][] grid = {{3, 2}, {0, 1}};

		System.out.println(swimInWater(grid));
	}

	public static int swimInWater(int[][] grid) {
		PriorityQueue<coor> q = new PriorityQueue<>(new Comparator<coor>() {
			@Override
			public int compare(coor o1, coor o2) {
				return o1.elevation - o2.elevation;
			}
		});
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int elevation = Integer.MAX_VALUE;

		q.add(new coor(0, 0, grid[0][0]));
		grid[0][0] = -1;

		while(!q.isEmpty()) {
			coor c = q.poll();

			//System.out.println("c.x : " + c.x + " | c.y : " + c.y + " | c.e : " + c.elevation + " | grid[" + c.x + "][" + c.y + "] : " + grid[c.x][c.y]);

			if(c.x == grid.length - 1 && c.y == grid[0].length - 1 && elevation > c.elevation) {
				elevation = c.elevation;
			}

			for(int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];
				int currE = c.elevation;

				if(currX >= 0 && currX < grid.length && currY >= 0 && currY < grid[0].length) {
					int nextE = grid[currX][currY];
					if(nextE != -1) {
						//System.out.println("currX : " + currX + " | currY : " + currY + " | currE : " + currE + " | grid[" + currX + "][" + currY + "](nextE) : " + grid[currX][currY]);
						if(currE < nextE) {
							q.add(new coor(currX, currY, nextE));
						} else {
							q.add(new coor(currX, currY, currE));
						}

						grid[currX][currY] = -1;
					}
				}
			} // end of for

		} // end of while

		return elevation;
	}
}