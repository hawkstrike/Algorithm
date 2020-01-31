package BaekJoon.java;
// https://www.acmicpc.net/problem/5086

import java.util.Scanner;

public class baekjoon_5086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if(x == y)
				break;

			String flag = (y % x == 0) ? "factor" : (x % y == 0) ? "multiple" : "neither";
			System.out.println(flag);
		}

		sc.close();
	}
}