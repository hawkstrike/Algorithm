package BaekJoon.java;
// https://www.acmicpc.net/problem/10797

import java.util.Scanner;

public class baekjoon_10797 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		int count = 0;

		for(int i = 0; i < 5; i++) {
			if(sc.nextInt() == day)
				count++;
		}

		System.out.println(count);
		sc.close();
	}
}