package BaekJoon.java;
// https://www.acmicpc.net/problem/10952

import java.util.Scanner;

public class baekjoon_10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if(x == 0 && y == 0)
				break;

			System.out.println(x + y);
		}

		sc.close();
	}
}