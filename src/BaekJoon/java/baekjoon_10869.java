package BaekJoon.java;
// https://www.acmicpc.net/problem/10869

import java.util.Scanner;

public class baekjoon_10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();

		System.out.println(i + j);
		System.out.println(i - j);
		System.out.println(i * j);
		System.out.println(i / j);
		System.out.println(i % j);

		sc.close();
	}
}