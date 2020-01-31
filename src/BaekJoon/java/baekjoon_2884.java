package BaekJoon.java;
// https://www.acmicpc.net/problem/2884

import java.util.Scanner;

public class baekjoon_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt() - 45;

		if(m < 0) {
			m += 60;
			h--;
			if(h < 0)
				h = 23;
		}

		System.out.println(h + " " + m);
		sc.close();
	}
}