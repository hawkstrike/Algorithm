package BaekJoon.java;
// https://www.acmicpc.net/problem/11966

import java.util.Scanner;

public class baekjoon_11966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean flag = false;

		for(int i = 0; i <= 30; i++) {
			if(Math.pow(2, i) == n) {
				flag = true;
				break;
			}
		}

		if(flag)
			System.out.println("1");
		else
			System.out.println("0");

		sc.close();
	}
}