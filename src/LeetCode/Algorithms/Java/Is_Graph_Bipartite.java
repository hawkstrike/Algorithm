package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/is-graph-bipartite/
public class Is_Graph_Bipartite {
	public static void main(String[] args) {
		int[][] graph = {{1, 3},
						{0, 2},
						{1, 3},
						{0, 2}};
		
		System.out.println(isBipartite(graph));
	}
	
	public static boolean isBipartite(int[][] graph) {
		int length = graph.length;
		int[] visited = new int[length];
		
		for (int i = 0; i < length; i++) {
			if (graph[i].length > 0 && visited[i] == 0) {
				Queue<Integer> queue = new LinkedList<>();
				
				queue.offer(i);
				visited[i] = 1;
				
				while (!queue.isEmpty()) {
					int curr = queue.poll();
					
					for (int g : graph[curr]) {
						if (visited[g] == 0) {
							queue.offer(g);
							visited[g] = (visited[curr] == 1) ? 2 : 1;
						} else {
							if (visited[g] == visited[curr]) {
								return false;
							}
						}
					}
				}
			}
		}
		
		return true;
	}
}