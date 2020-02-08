package LeetCode.Algorithms;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
public class Find_N_Unique_Integers_Sum_up_to_Zero {
	public static void main(String[] args){
		int n = 5;
		int[] result = sumZero(n);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static int[] sumZero(int n) {
		int[] result = new int[n];
		int size = n / 2;
		int index = 0;
		
		while (size > 0) {
			result[index++] = -size;
			result[index++] = size;
			size--;
		}
		
		return result;
	}
}