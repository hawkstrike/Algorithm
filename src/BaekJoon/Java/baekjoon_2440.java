package BaekJoon.Java;
// https://www.acmicpc.net/problem/2440

import java.util.Scanner;

public class baekjoon_2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - i; j++)
				System.out.print("*");
			System.out.println();
		}

		sc.close();
	}
}