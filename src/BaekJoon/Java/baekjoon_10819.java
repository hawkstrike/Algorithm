package BaekJoon.Java;
// https://www.acmicpc.net/problem/10819

import java.util.Scanner;

public class baekjoon_10819 {
	static int n, sum = 0, max = 0;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		permutation(0);

		System.out.println(max);
		sc.close();
	}

	public static void permutation(int x) {
		if(x == n)
			return;

		for(int i = x; i < n; i++) {
			swap(x, i);
			sum = 0;

			for(int j = 0; j < n-1; j++)
				sum += Math.abs(arr[j] - arr[j+1]);

			if(sum > max)
				max = sum;

			permutation(x+1);
			swap(x, i);
		}
	}

	public static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}