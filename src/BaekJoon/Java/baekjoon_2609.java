package BaekJoon.Java;
// https://www.acmicpc.net/problem/2609

import java.util.Scanner;

public class baekjoon_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		if(y > x) {
			int temp = x;
			x = y;
			y = temp;
		}

		int r1 = x % y;
		int r2 = (r1 == 0) ? y : y % r1;

		while(r1 != 0 && r2 != 0) {
			r1 %= r2;
			if(r1 != 0)
				r2 %= r1;
		}

		int gcd = (r1 == 0) ? r2 : r1;
		int lcm = x * y / gcd;

		System.out.println(gcd);
		System.out.println(lcm);
		sc.close();
	}
}