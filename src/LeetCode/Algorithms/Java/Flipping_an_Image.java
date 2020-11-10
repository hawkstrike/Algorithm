package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/flipping-an-image/
public class Flipping_an_Image {
	public static void main(String[] args) {
		int[][] A = {{1, 1, 0},
					{1, 0, 1},
					{0, 0, 0}};
		int[][] result = flipAndInvertImage(A);
		
		for (int[] arr : result) {
			for (int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] flipAndInvertImage(int[][] A) {
		int length = A[0].length;
		
		for (int[] arr : A) {
			for (int i = 0; i < (length + 1) / 2; i++) {
				int tmp = arr[i] ^ 1;
				arr[i] = arr[length - 1 - i] ^ 1;
				arr[length - 1 - i] = tmp;
			}
		}
		
		return A;
	}
}