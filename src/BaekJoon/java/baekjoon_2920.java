package BaekJoon.java;
// https://www.acmicpc.net/problem/2920

import java.util.Scanner;

public class baekjoon_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scale = new int[9];
		boolean b = true;
		boolean c = true;

		for(int i = 1; i < scale.length; i++)
			scale[i] = sc.nextInt();

		for(int i = 1; i < scale.length; i++) {
			if(scale[i] != i)
				b = false;
		}

		for(int i = 1; i < scale.length; i++) {
			if(scale[i] != 9-i)
				c = false;
		}

		if(b == true && c == false)
			System.out.println("ascending");
		else if(b == false && c == true)
			System.out.println("descending");
		else
			System.out.println("mixed");

		sc.close();
	}
}