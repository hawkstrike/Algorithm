package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/clone-graph/
public class Clone_Graph {
	static class Node {
		public int val;
		public List<Node> neighbors;
		
		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}
		
		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<>();
		}
		
		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
	
	public static void main(String[] args) {
		int[][] adjList = {{2, 4},
							{1, 3},
							{2, 4},
							{1, 3}};
		Node node = new Node();
		
		for (int i = 0; i < adjList.length; i++) {
			Node curr = new Node((i + 1));
			List<Node> list = new ArrayList<>();
			
			for (int j = 0; j < adjList[i].length; j++) {
				list.add(new Node(adjList[i][j]));
			}
			
			curr.neighbors = list;
			node.neighbors.addAll(curr.neighbors);
		}
		
		Node result = cloneGraph(node);
		
		
	}
	
	public static Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		
		Queue<Node> q = new LinkedList<>();
		HashMap<Node, Node> hashMap = new HashMap<>();
		
		q.offer(node);
		hashMap.put(node, new Node(node.val));
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for (Node n : curr.neighbors) {
				if (!hashMap.containsKey(n)) {
					hashMap.put(n, new Node(n.val));
					q.add(n);
				}
				
				hashMap.get(curr).neighbors.add(hashMap.get(n));
			}
		}
		
		return hashMap.get(node);
	}
}