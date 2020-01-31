package BaekJoon.java;
// https://www.acmicpc.net/problem/1722

import java.util.Scanner;

public class baekjoon_1722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] f = new long[21];
		boolean[] b = new boolean[21];

		f[0] = 1;

		for(int i = 1; i <= 20; i++)
			f[i] = f[i-1] * i;

		int n = sc.nextInt();
		int order = sc.nextInt();
		int[] arr = new int[n];

		if(order == 2) {
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			long ans = 0;

			for(int i = 0; i < n; i++) {
				for(int j = 1; j < arr[i]; j++)
					if(!b[j])
						ans += f[n-i-1];
				b[arr[i]] = true;
			}

			System.out.println(ans+1);
		} else {
			long k = sc.nextLong();

			for(int i = 0; i < n; i++) {
				for(int j = 1; j <= n; j++) {
					if(b[j])
						continue;

					if(f[n-i-1] < k) {
						k -= f[n-i-1];
					} else {
						arr[i] = j;
						b[j] = true;
						break;
					}
				}
			}

			for(int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");

			System.out.println();
		}

		sc.close();
	}
}