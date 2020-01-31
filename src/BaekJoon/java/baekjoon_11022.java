package BaekJoon.java;
// https://www.acmicpc.net/problem/11022

import java.util.Scanner;

public class baekjoon_11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			System.out.println("Case #" + i +": " + x + " + " + y + " = " + (x + y));
		}

		sc.close();
	}
}