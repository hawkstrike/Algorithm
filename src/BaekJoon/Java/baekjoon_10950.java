package BaekJoon.Java;
// https://www.acmicpc.net/problem/10950

import java.util.Scanner;

public class baekjoon_10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++)
			System.out.println(sc.nextInt() + sc.nextInt());

		sc.close();
	}
}