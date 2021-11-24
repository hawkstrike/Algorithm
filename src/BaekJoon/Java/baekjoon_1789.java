package BaekJoon.Java;
// https://www.acmicpc.net/problem/1789

import java.util.Scanner;

public class baekjoon_1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long check = 0;
		long count = 1;

		while(count < n) {
			check += count;
			if(check > n)
				break;
			count++;
		}

		System.out.println(count-1);

		sc.close();
	}
}