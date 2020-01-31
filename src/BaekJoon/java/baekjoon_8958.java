package BaekJoon.java;
// https://www.acmicpc.net/problem/8958

import java.util.Scanner;

public class baekjoon_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for(int i = 0; i < n; i++) {
			char[] c = sc.nextLine().toCharArray();
			int count = 0;
			int sum = 0;

			for(int j = 0; j < c.length; j++) {
				if(c[j] == 'O') {
					count++;
					sum += count;
				} else {
					count = 0;
				}
			}

			System.out.println(sum);
		}

		sc.close();
	}
}