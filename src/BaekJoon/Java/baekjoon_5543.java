package BaekJoon.Java;
// https://www.acmicpc.net/problem/5543

import java.util.Scanner;

public class baekjoon_5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] burger = new int[3];
		int minBurger = 2001, minBever = 2001;

		for(int i = 0; i < 3; i++) {
			burger[i] = sc.nextInt();

			if(burger[i] < minBurger)
				minBurger = burger[i];
		}

		int[] bever = new int[2];

		for(int i = 0; i < 2; i++) {
			bever[i] = sc.nextInt();

			if(bever[i] < minBever)
				minBever = bever[i];
		}

		System.out.println(minBurger + minBever - 50);
		sc.close();
	}
}