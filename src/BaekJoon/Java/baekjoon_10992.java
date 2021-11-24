package BaekJoon.Java;
// https://www.acmicpc.net/problem/10992

import java.util.Scanner;

public class baekjoon_10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - i - 1; j++)
				System.out.print(" ");

			System.out.print("*");

			for(int j = 0; j < i * 2 - 1 && i != n - 1; j++)
				System.out.print(" ");

			if(i != 0 && i != n - 1)
				System.out.print("*");

			if(i == n - 1) {
				for(int j = 0; j < 2 * i; j++)
					System.out.print("*");
			}

			System.out.println();
		}

		sc.close();
	}
}