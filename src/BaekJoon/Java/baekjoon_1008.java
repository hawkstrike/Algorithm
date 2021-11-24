package BaekJoon.Java;
// https://www.acmicpc.net/problem/1008

import java.util.Scanner;

public class baekjoon_1008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double i = 0, j = 0;

		i = sc.nextDouble();
		j = sc.nextDouble();

		System.out.println(i / j);

		sc.close();
	}
}