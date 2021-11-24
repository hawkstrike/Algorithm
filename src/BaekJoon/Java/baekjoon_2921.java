package BaekJoon.Java;
// https://www.acmicpc.net/problem/2921

import java.util.Scanner;

public class baekjoon_2921 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;

		for(int i = 1; i <= n; i++) {
			for(int j = i+1; j <=n+1; j++)
				sum = sum + i + j;
		}

		System.out.println(sum);
		sc.close();
	}
}