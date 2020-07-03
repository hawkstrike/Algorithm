package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/prison-cells-after-n-days/
public class Prison_Cells_After_N_Days {
	public static void main(String[] args) {
		int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
		int N = 7;
		/*int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
		int N = 1000000000;*/
		
		int[] result = prisonAfterNDays(cells, N);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] prisonAfterNDays(int[] cells, int N) {
		int[] result = new int[cells.length];
		int loopCount = (N % 14 == 0) ? 14 : N % 14;
		
		result[0] = 0;
		result[cells.length - 1] = 0;
		
		while (loopCount > 0) {
			for (int i = 1; i < cells.length - 1; i++) {
				result[i] = (cells[i - 1] ^ cells[i + 1]) ^ 1;
				//result[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
			}
			
			cells = result.clone();
			loopCount--;
		}
		
		return result;
	}
}