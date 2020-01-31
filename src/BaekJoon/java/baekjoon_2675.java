package BaekJoon.java;
// https://www.acmicpc.net/problem/2675

import java.util.Scanner;

public class baekjoon_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int r = sc.nextInt();
			String s = sc.nextLine();

			for(int j = 1; j < s.length(); j++) {
				for(int k = 0; k < r; k++)
					System.out.print(s.charAt(j));
			}

			System.out.println();
		}

		sc.close();
	}
}