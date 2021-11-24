package BaekJoon.Java;
// https://www.acmicpc.net/problem/10998

import java.util.Scanner;

public class baekjoon_10998 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0, j = 0;

		i = sc.nextInt();
		j = sc.nextInt();

		System.out.println(i * j);

		sc.close();
	}
}