package BaekJoon.Java;
// https://www.acmicpc.net/problem/9325

import java.util.Scanner;

public class baekjoon_9325 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int sum = sc.nextInt();
			int m = sc.nextInt();

			for(int j = 0; j < m; j++)
				sum += sc.nextInt() * sc.nextInt();

			System.out.println(sum);
		}

		sc.close();
	}
}