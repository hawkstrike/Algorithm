package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/beautiful-arrangement/
public class Beautiful_Arrangement {
	public static int count = 0;
	
	public static void main(String[] args) {
		int n = 2;
		
		System.out.println(countArrangement(n));
	}
	
	public static int countArrangement(int n) {
		boolean[] visited = new boolean[n + 1];
		
		recurrentCountArrangement(n, 1, visited);
		
		return count;
	}
	
	public static void recurrentCountArrangement(int n, int position, boolean[] visited) {
		if (position > n) {
			count++;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && (position % i == 0 || i % position == 0)) {
				visited[i] = true;
				recurrentCountArrangement(n, position + 1, visited);
				visited[i] = false;
			}
		}
	}
}