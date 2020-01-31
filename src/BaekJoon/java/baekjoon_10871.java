package BaekJoon.java;
// https://www.acmicpc.net/problem/10871

import java.util.Scanner;

public class baekjoon_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int a;

		for(int i = 0 ; i < n; i++) {
			if((a = sc.nextInt()) < x)
				System.out.print(a + " ");
		}

		sc.close();
	}
}