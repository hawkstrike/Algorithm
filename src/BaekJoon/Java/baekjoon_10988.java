package BaekJoon.Java;
// https://www.acmicpc.net/problem/10988

import java.util.Scanner;

public class baekjoon_10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		boolean flag = false;

		for(int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
				flag = true;
				break;
			}
		}

		System.out.println((flag) ? "0" : "1");

		sc.close();
	}
}