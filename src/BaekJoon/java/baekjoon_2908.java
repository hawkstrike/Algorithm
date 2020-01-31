package BaekJoon.java;
// https://www.acmicpc.net/problem/2908

import java.util.Scanner;

public class baekjoon_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();

		s1.append(sc.next());
		s2.append(sc.next());

		s1.reverse();
		s2.reverse();

		System.out.println((Integer.parseInt(s1.toString()) > Integer.parseInt(s2.toString()) ? s1.toString() : s2.toString()));
		sc.close();
	}
}