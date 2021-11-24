package BaekJoon.Java;
// https://www.acmicpc.net/problem/10430

import java.util.Scanner;

public class baekjoon_10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();

		System.out.println((i + j) % k);
		System.out.println(((i % k) + (j % k)) % k);
		System.out.println((i * j) % k);
		System.out.println(((i % k) * (j % k)) % k);

		sc.close();
	}
}