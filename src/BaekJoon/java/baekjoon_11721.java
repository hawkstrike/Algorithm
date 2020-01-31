package BaekJoon.java;
// https://www.acmicpc.net/problem/11721

import java.util.Scanner;

public class baekjoon_11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		for(int i = 1; i <= s.length(); i++) {
			System.out.print(s.charAt(i-1));

			if((i % 10) == 0)
				System.out.println();
		}

		sc.close();
	}
}