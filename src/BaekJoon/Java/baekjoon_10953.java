package BaekJoon.Java;
// https://www.acmicpc.net/problem/10953

import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
			System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		}

		sc.close();
	}
}