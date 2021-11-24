package BaekJoon.Java;
// https://www.acmicpc.net/problem/11720

import java.util.Scanner;

public class baekjoon_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int sum = 0;
		String s = sc.nextLine();

		for(int i = 0; i < n; i++)
			sum += (int)s.charAt(i) - 48;

		System.out.println(sum);
		sc.close();
	}
}