package BaekJoon.java;
// https://www.acmicpc.net/problem/1152

import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		StringTokenizer t = new StringTokenizer(s);
		int n = t.countTokens();

		System.out.println(n);

		sc.close();
	}
}