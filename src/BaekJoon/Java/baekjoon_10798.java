package BaekJoon.Java;
// https://www.acmicpc.net/problem/10798

import java.util.Scanner;

public class baekjoon_10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] c = new char[5][15];

		for(int i = 0; i < 5; i++) {
			String s = sc.nextLine();

			for(int j = 0; j < s.length(); j++)
				c[i][j] = s.charAt(j);
		}

		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++)
				if(c[j][i] != 0)
					System.out.print(c[j][i]);
		}

		System.out.println();
		sc.close();
	}
}