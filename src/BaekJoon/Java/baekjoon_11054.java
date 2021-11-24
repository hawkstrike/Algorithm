package BaekJoon.Java;
// https://www.acmicpc.net/problem/11054

import java.util.Scanner;

public class baekjoon_11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp1[i] = dp2[i] = 1;

			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
			}
		}

		for(int i = n - 1; i >= 0; i--) {
			for(int j = i + 1; j < n; j++)
				if(arr[i] > arr[j])
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
		}

		int max = 0;

		for(int i = 0; i < n; i++)
			max = Math.max(max, dp1[i] + dp2[i] - 1);

		System.out.println(max);
		sc.close();
	}
}