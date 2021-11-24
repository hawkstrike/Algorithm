package BaekJoon.Java;
// https://www.acmicpc.net/problem/2742

import java.util.Scanner;

public class baekjoon_2742 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = n;

		for(int i = 0; i < l; i++)
			System.out.println(n--);

		sc.close();
	}
}