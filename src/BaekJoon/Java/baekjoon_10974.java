package BaekJoon.Java;
// https://www.acmicpc.net/problem/10974

import java.util.Scanner;

public class baekjoon_10974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 1; i <= n; i++)
			arr[i-1] = i;

		printf(arr);

		while(next_permutation(arr, n))
			printf(arr);

		sc.close();
	}

	public static void printf(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static boolean next_permutation(int[] arr, int n) {
		int i = n - 1;

		while(i > 0 && arr[i-1] >= arr[i])
			i--;

		if(i <= 0)
			return false;

		int j = n - 1;

		while(arr[j] <= arr[i-1])
			j--;

		swap(arr, i-1, j);
		j = n - 1;

		while(i < j)
			swap(arr, i++, j--);

		return true;
	}

	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}