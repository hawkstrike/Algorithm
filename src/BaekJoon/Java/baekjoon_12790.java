package BaekJoon.Java;
// https://www.acmicpc.net/problem/12790

import java.util.Scanner;

public class baekjoon_12790 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int[] arr = new int[4];

			for(int j = 0; j < 4; j++)
				arr[j] = sc.nextInt();

			for(int j = 0; j < 4; j++)
				arr[j] += sc.nextInt();

			if(arr[0] < 1)
				arr[0] = 1;

			if(arr[1] < 1)
				arr[1] = 1;

			if(arr[2] < 0)
				arr[2] = 0;

			System.out.println(arr[0] + (5*arr[1]) + (2*arr[2]) + (2*arr[3]));
		}

		sc.close();
	}
}