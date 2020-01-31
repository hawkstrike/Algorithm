package BaekJoon.java;
// https://www.acmicpc.net/problem/10951

import java.util.Scanner;

public class baekjoon_10951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextInt())
			System.out.println(sc.nextInt() + sc.nextInt());

		sc.close();
	}
}