package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/possible-bipartition/
public class Possible_Bipartition {
	public static void main(String[] args) {
		int N = 4;
		int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
		
		System.out.println(possibleBipartition(N, dislikes));
	}
	
	public static boolean possibleBipartition(int N, int[][] dislikes) {
		int[][] graph = new int[N + 1][N + 1];
		int[] person = new int[N + 1];
		
		for (int[] dislike : dislikes) {
			graph[dislike[0]][dislike[1]] = 1;
			graph[dislike[1]][dislike[0]] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			if (person[i] == 0 && !dfs(graph, person, i, 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean dfs(int[][] graph, int[] person, int curr, int p) {
		if (person[curr] != 0) {
			return true;
		}
		
		person[curr] = p;
		
		for (int i = 1; i < graph[curr].length; i++) {
			if (graph[curr][i] == 1) {
				if (person[i] == p || !dfs(graph, person, i, -p)) {
					return false;
				}
			}
		}
		
		return true;
	}
}