package Programmers.SkillCheck.Java;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_1 {
	
	public static void main(String[] args) {
		/*int[][] maps = {{1, 0, 1, 1, 1},
						{1, 0, 1, 0, 1},
						{1, 0, 1, 1, 1},
						{1, 1, 1, 0, 1},
						{0, 0, 0, 0, 1}};*/
		int[][] maps = {{1, 0, 1, 1, 1},
						{1, 0, 1, 0, 1},
						{1, 0, 1, 1, 1},
						{1, 1, 1, 0, 0},
						{0, 0, 0, 0, 1}};
		
		System.out.println(solution(maps));
	}
	
	public static int solution(int[][] maps) {
		Queue<coor> queue = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int n = maps.length - 1;
		int m = maps[0].length - 1;
		
		queue.offer(new coor(0, 0, 1));
		maps[0][0] = -1;
		
		while (!queue.isEmpty()) {
			coor c = queue.poll();
			
			if (c.x == n && c.y == m) {
				return c.paths;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int currX = c.x + dx[i];
				int currY = c.y + dy[i];
				
				if (currX >= 0 && currY >= 0 && currX <= n && currY <= m && maps[currX][currY] == 1) {
					queue.offer(new coor(currX, currY, c.paths + 1));
					maps[currX][currY] = -1;
				}
			}
		}
		
		return -1;
	}
	
	public static class coor {
		int x;
		int y;
		int paths;
		
		public coor(int x, int y, int paths) {
			this.x = x;
			this.y = y;
			this.paths = paths;
		}
	}
}