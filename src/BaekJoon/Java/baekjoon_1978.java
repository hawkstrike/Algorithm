package BaekJoon.Java;
// https://www.acmicpc.net/problem/1978

import java.util.Scanner;

public class baekjoon_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[1001];

		arr[1] = 1;
		for(int i = 2; i < 101; i++) {
			for(int j = 2 * i; j < 1001; j += i)
				arr[j] = 1;
		}

		int cnt = 0;
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();
			if(arr[m] == 0)
				cnt++;
		}

		System.out.println(cnt);
		sc.close();
	}
}