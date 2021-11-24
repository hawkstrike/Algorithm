package BaekJoon.Java;
// https://www.acmicpc.net/problem/1924

import java.util.Scanner;

public class baekjoon_1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int d = sc.nextInt();
		String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		for(int i = 0; i < m - 1; i++)
			d += day[i];
		d %= 7;

		System.out.println(date[d]);
		sc.close();
	}
}