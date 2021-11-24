package BaekJoon.Java;
// https://www.acmicpc.net/problem/5789

import java.util.Scanner;

public class baekjoon_5789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();

			if(s.charAt((s.length()/2)-1) == s.charAt(s.length()/2))
				System.out.println("Do-it");
			else
				System.out.println("Do-it-Not");
		}

		sc.close();
	}
}