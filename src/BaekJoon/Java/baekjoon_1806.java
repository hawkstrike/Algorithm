package BaekJoon.Java;
// https://www.acmicpc.net/problem/1806

import java.util.Scanner;

public class baekjoon_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int S = sc.nextInt();
		int[] arr = new int[n+1];

		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		int left = 0, sum = 0, min = Integer.MAX_VALUE;

		for(int i = 1; i <= n; i++) {
			sum += arr[i];

			while(sum >= S) {
				min = Math.min(min, i-left);
				left++;
				sum -= arr[left];
			}
		}

		System.out.println((min == Integer.MAX_VALUE) ? "0" : min);
		sc.close();
	}
}