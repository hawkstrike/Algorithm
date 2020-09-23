package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/gas-station/
public class Gas_Station {
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		
		System.out.println(canCompleteCircuit(gas, cost));
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int curr = 0;
		int total = 0;
		int candidate = 0;
		
		for (int i = 0; i < gas.length; i++) {
			curr += gas[i] - cost[i];
			total += gas[i] - cost[i];
			
			if (curr < 0) {
				candidate = i + 1;
				curr = 0;
			}
		}
		
		return total >= 0 ? candidate : - 1;
	}
}