package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/all-paths-from-source-to-target/
public class All_Paths_From_Source_to_Target {
	public static void main(String[] args) {
		int[][] graph = {{1, 2},
						{3},
						{3},
						{}};
		List<List<Integer>> result = allPathsSourceTarget(graph);
		
		for (List<Integer> list : result) {
			for (Integer n : list) {
				System.out.print(n + " ");
			}
			
			System.out.println();
		}
	}
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> q = new LinkedList<>();
		
		q.offer(new ArrayList<>(Arrays.asList(0)));
		
		while (!q.isEmpty()) {
			List<Integer> currList = q.poll();
			int lastInteger = currList.get(currList.size() - 1);
			
			if (lastInteger == graph.length - 1) {
				result.add(currList);
			}
			
			for (int n : graph[lastInteger]) {
				List<Integer> list = new ArrayList<>(currList);
				
				list.add(n);
				q.offer(list);
			}
		}
		
		return result;
	}
}