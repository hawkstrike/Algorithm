package BaekJoon.java;
// https://www.acmicpc.net/problem/5063

import java.util.Scanner;

public class baekjoon_5063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int r = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();

			System.out.println((e - c > r) ? "advertise" : (e - c < r) ? "do not advertise" : "does not matter");
		}

		sc.close();
	}
}