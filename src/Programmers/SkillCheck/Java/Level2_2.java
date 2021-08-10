package Programmers.SkillCheck.Java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level2_2 {
	
	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1, 2, 1},
						{2, 3, 3},
						{5, 2, 2},
						{1, 4, 2},
						{5, 3, 1}};
		int K = 3;
		/*int N = 6;
		int[][] road = {{1, 2, 1},
						{1, 3, 2},
						{2, 3, 2},
						{3, 4, 3},
						{3, 5, 2},
						{3, 5, 3},
						{5, 6, 1}};
		int K = 4;*/
		
		System.out.println(solution(N, road, K));
	}
	
	public static int solution(int N, int[][] road, int K) {
		Queue<int[]> queue = new LinkedList<>();
		List<int[]>[] list = new LinkedList[N + 1];
		int[] distance = new int[N + 1];
		int result = 0;
		
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < road.length; i++) {
			list[road[i][0]].add(new int[]{road[i][0], road[i][1], road[i][2]});
			list[road[i][1]].add(new int[]{road[i][1], road[i][0], road[i][2]});
		}
		
		queue.offer(new int[]{0, 1, 0});
		distance[1] = 0;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			List<int[]> currPaths = list[curr[1]];
			
			if (distance[curr[1]] < curr[2]) {
				continue;
			}
			
			for (int[] path : currPaths) {
				int sum = curr[2] + path[2];
				
				if (distance[path[1]] > sum) {
					queue.offer(new int[]{curr[1], path[1], sum});
					distance[path[1]] = sum;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (distance[i] <= K) {
				result++;
			}
		}
		
		return result;
	}
}