package BaekJoon.java;
// https://www.acmicpc.net/problem/2442

import java.util.Scanner;

public class baekjoon_2442 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			for(int j = i; j < n - 1; j++)
				System.out.print(" ");

			for(int j = 0; j < i * 2 + 1; j++)
				System.out.print("*");
			System.out.println();
		}

		sc.close();
	}
}