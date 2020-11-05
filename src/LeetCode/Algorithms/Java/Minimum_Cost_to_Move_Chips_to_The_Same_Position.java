package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
public class Minimum_Cost_to_Move_Chips_to_The_Same_Position {
	public static void main(String[] args) {
		int[] position = {1, 2, 3};
		
		System.out.println(minCostToMoveChips(position));
	}
	
	public static int minCostToMoveChips(int[] position) {
		int odd = 0;
		int even = 0;
		
		for (int i : position) {
			if (i % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		
		return Math.min(odd, even);
	}
}