package BaekJoon.Java;
// https://www.acmicpc.net/problem/10991

import java.util.Scanner;

public class baekjoon_10991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - i - 1; j++)
				System.out.print(" ");

			System.out.print("*");

			for(int j = 1; j <= (2 * i) / 2; j++)
				System.out.print(" *");
			System.out.println();
		}

		sc.close();
	}
}