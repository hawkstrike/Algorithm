package BaekJoon.Java;
// https://www.acmicpc.net/problem/10886

import java.util.Scanner;

public class baekjoon_10886 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;

		for(int i = 0; i < n; i++) {
			if(sc.nextInt() == 0)
				count++;
		}

		System.out.println((count > n / 2) ? "Junhee is not cute!" : "Junhee is cute!");
		sc.close();
	}
}