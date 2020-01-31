package BaekJoon.java;
// https://www.acmicpc.net/problem/2446

import java.util.Scanner;

public class baekjoon_2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++)
				System.out.print(" ");

			for(int j = i; j < 2 * n - i - 1; j++)
				System.out.print("*");
			System.out.println();
		}

		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n - i; j++)
				System.out.print(" ");

			for(int j = i; j < (i * 2) * 2 - i + 1; j++)
				System.out.print("*");
			System.out.println();
		}

		sc.close();
	}
}