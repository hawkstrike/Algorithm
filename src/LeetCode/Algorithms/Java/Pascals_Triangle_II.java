package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/
public class Pascals_Triangle_II {
	public static void main(String[] args) {
		int rowIndex = 3;
		List<Integer> result = getRow(rowIndex);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		
		System.out.println();
	}
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new LinkedList<>();
		
		for (int i = 0; i <= rowIndex; i++) {
			result.add(1);
			
			for (int j = i - 1; j > 0; j--) {
				result.set(j, result.get(j - 1) + result.get(j));
			}
		}
		
		return result;
	}
}