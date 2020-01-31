package BaekJoon.java;
// https://www.acmicpc.net/problem/2490

import java.util.Scanner;

public class baekjoon_2490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++)
				arr[j] = sc.nextInt();

			int count = 0;

			for (int j = 0; j < 4; j++)
				if (arr[j] == 1)
					count++;

			char c = (count == 0) ? 'D' : (count == 1) ? 'C' : (count == 2) ? 'B' : (count == 3) ? 'A' : 'E';
			System.out.println(c);
		}

		sc.close();
	}
}