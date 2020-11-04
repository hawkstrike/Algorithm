package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/
public class Minimum_Height_Trees {
	public static void main(String[] args) {
		/*int n = 4;
		int[][] edges = {{1, 0},
						{1, 2},
						{1, 3}};*/
		int n = 6;
		int[][] edges = {{3, 0},
						{3, 1},
						{3, 2},
						{3, 4},
						{5, 4}};
		List<Integer> result = findMinHeightTrees(n, edges);
		
		for (int reaf : result) {
			System.out.println(reaf);
		}
	}
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) {
			return Arrays.asList(0);
		}
		
		List<Integer>[] adjList = new LinkedList[n];
		List<Integer> leaves = new LinkedList<>();
		int[] degree = new int[n];
		
		for (int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<>();
		}
		
		for (int[] edge : edges) {
			degree[edge[0]]++;
			degree[edge[1]]++;
			adjList[edge[0]].add(edge[1]);
			adjList[edge[1]].add(edge[0]);
		}
		
		for (int i = 0; i < n; i++) {
			if (degree[i] == 1) {
				leaves.add(i);
			}
		}
		
		List<Integer> temp = new LinkedList<>();
		
		while (n > 2) {
			temp = new LinkedList<>();
			
			for (int leaf : leaves) {
				for (int adj : adjList[leaf]) {
					degree[adj]--;
					
					if (degree[adj] == 1) {
						temp.add(adj);
					}
				}
			}
			
			n -= leaves.size();
			leaves = temp;
		}
		
		return leaves;
		
		/*if (n <= 1) {
			List<Integer> list = new LinkedList<>();
			list.add(0);
			
			return list;
		}
		
		List<Set<Integer>> neighbors = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			neighbors.add(new HashSet<>());
		}
		
		for (int[] edge : edges) {
			neighbors.get(edge[0]).add(edge[1]);
			neighbors.get(edge[1]).add(edge[0]);
		}
		
		List<Integer> leaves = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			if (neighbors.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		
		int node = n;
		
		while (node > 2) {
			List<Integer> newLeaves = new LinkedList<>();
			
			node -= leaves.size();
			
			for (int leaf : leaves) {
				for (int neighbor : neighbors.get(leaf)) {
					neighbors.get(neighbor).remove(leaf);
					
					if (neighbors.get(neighbor).size() == 1) {
						newLeaves.add(neighbor);
					}
				}
			}
			
			leaves = newLeaves;
		}
		
		return leaves;*/
	}
}