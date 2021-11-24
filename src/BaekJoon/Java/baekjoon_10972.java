package BaekJoon.Java;
// https://www.acmicpc.net/problem/10972

import java.util.Scanner;

public class baekjoon_10972 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		boolean flag = next_permutation(arr, n);

		if(flag) {
			for(int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		} else {
			System.out.println("-1");
		}

		sc.close();
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