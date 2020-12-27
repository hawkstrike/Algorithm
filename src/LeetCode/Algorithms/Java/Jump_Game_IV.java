package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/jump-game-iv/
public class Jump_Game_IV {
	public static void main(String[] args) {
		//int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
		//int[] arr = {7};
		//int[] arr = {7, 6, 9, 6, 9, 6, 9, 7};
		//int[] arr = {6, 1, 9};
		int[] arr = {11, 22, 7, 7, 7, 7, 7, 7, 22, 13};
		
		System.out.println(minJumps(arr));
	}
	
	public static int minJumps(int[] arr) {
		int length = arr.length;
		
		if (length <= 1) {
			return 0;
		}
		
		HashMap<Integer, List<Integer>> graphList = new HashMap<>();
		
		for (int i = 0; i < length; i++) {
			graphList.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
		}
		
		List<Integer> curs = new LinkedList<>();
		List<Integer> other = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		int step = 0;
		
		curs.add(0);
		other.add(length - 1);
		visited.add(0);
		visited.add(length - 1);
		
		while (!curs.isEmpty()) {
			if (curs.size() > other.size()) {
				List<Integer> list = curs;
				curs = other;
				other = list;
			}
			
			List<Integer> nex = new LinkedList<>();
			
			for (int node : curs) {
				for (int child : graphList.get(arr[node])) {
					if (other.contains(child)) {
						return step + 1;
					}
					
					if (!visited.contains(child)) {
						visited.add(child);
						nex.add(child);
					}
				}
				
				graphList.get(arr[node]).clear();
				
				if (other.contains(node + 1) || other.contains(node - 1)) {
					return step + 1;
				}
				
				if (node + 1 < length && !visited.contains(node + 1)) {
					visited.add(node + 1);
					nex.add(node + 1);
				}
				
				if (node - 1 >= 0 && !visited.contains(node - 1)) {
					visited.add(node - 1);
					nex.add(node - 1);
				}
			}
			
			curs = nex;
			step++;
		}
		
		return -1;
	}
}