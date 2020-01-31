package BaekJoon.java;
// https://www.acmicpc.net/problem/2960

import java.util.Scanner;

public class baekjoon_2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n+1];
		int ans = 0, remove = 1;

		while(k > 0) {
			remove++;

			for(int i = 1; i <= n && k > 0; i++) {
				if(remove * i <= n && arr[remove*i] == 0) {
					k--;
					arr[remove*i] = 1;
					ans = remove * i;
				}
			}
		}

		System.out.println(ans);
		sc.close();
	}
}