package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
public class The_K_Weakest_Rows_in_a_Matrix {
	public static void main(String[] args) {
		int[][] mat = {{1, 1, 0, 0, 0},
						{1, 1, 1, 1, 0},
						{1, 0, 0, 0, 0},
						{1, 1, 0, 0, 0},
						{1, 1, 1, 1, 1}};
		int k = 3;
		
		int[] result = kWeakestRows(mat, k);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] kWeakestRows(int[][] mat, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int[] result = new int[k];
		
		for (int i = 0; i < mat.length; i++) {
			int count = 0;
			
			for (int n : mat[i]) {
				if (n == 1) {
					count++;
				} else {
					break;
				}
			}
			
			hashMap.put(i, count);
		}
		
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hashMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue() == o2.getValue()) ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue();
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			Map.Entry<Integer, Integer> map = list.get(i);
			
			if (i >= k) {
				break;
			}
			
			result[i] = map.getKey();
		}
		
		return result;
	}
}