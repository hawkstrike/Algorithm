package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/evaluate-division/
public class Evaluate_Division {
	public static class Node {
		String label;
		double value;
		
		public Node(String label, double value) {
			this.label = label;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		String[][] equationsArr = {{"a", "b"},
									{"b", "c"}};
		List<List<String>> equations = new LinkedList<>();
		double[] values = {2.0, 3.0};
		String[][] queriesArr = {{"a", "c"},
								{"b", "a"},
								{"a", "e"},
								{"a", "a"},
								{"x", "x"}};
		List<List<String>> queries = new LinkedList<>();
		
		for (String[] arr : equationsArr) {
			equations.add(Arrays.asList(arr));
		}
		
		for (String[] arr : queriesArr) {
			queries.add(Arrays.asList(arr));
		}
		
		double[] result = calcEquation(equations, values, queries);
		
		for (double d : result) {
			System.out.println(d);
		}
	}
	
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		HashMap<String, Node> hashMap = new HashMap<>();
		
		for (int i = 0; i < equations.size(); i++) {
			String x = equations.get(i).get(0);
			String y = equations.get(i).get(1);
			Node node1 = find(hashMap, x);
			Node node2 = find(hashMap, y);
			
			if (!node1.label.equals(node2.label)) {
				hashMap.put(node1.label, new Node(node2.label, values[i] * node2.value / node1.value));
			}
		}
		
		double[] result = new double[queries.size()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = -1.0;
			
			String x = queries.get(i).get(0);
			String y = queries.get(i).get(1);
			
			if (!hashMap.containsKey(x) || !hashMap.containsKey(y)) {
				continue;
			}
			
			Node node1 = find(hashMap, x);
			Node node2 = find(hashMap, y);
			
			if (!node1.label.equals(node2.label)) {
				continue;
			}
			
			result[i] = node1.value / node2.value;
		}
		
		return result;
	}
	
	public static Node find(HashMap<String, Node> hashMap, String curr) {
		if (!hashMap.containsKey(curr)) {
			hashMap.put(curr, new Node(curr, 1.0));
		}
		
		Node currNode = hashMap.get(curr);
		double value = 1.0;
		
		while (!hashMap.get(curr).label.equals(curr)) {
			value *= hashMap.get(curr).value;
			curr = hashMap.get(curr).label;
		}
		
		currNode.label = curr;
		currNode.value = value;
		
		return currNode;
	}
}