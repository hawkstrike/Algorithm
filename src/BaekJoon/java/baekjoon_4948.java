package BaekJoon.java;
// https://www.acmicpc.net/problem/4948

import java.util.Scanner;

public class baekjoon_4948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[246913];
		int n;

		for(int i = 2; i <= 246912; i++) {
			for(int j = 2 * i; j <= 246912; j += i)
				arr[j] = 1;
		}

		while((n = sc.nextInt()) != 0) {
			int cnt = 0;

			for(int i = n+1; i <= 2*n; i++) {
				if(arr[i] == 0)
					cnt++;
			}

			System.out.println(cnt);
		}

		sc.close();
	}
}