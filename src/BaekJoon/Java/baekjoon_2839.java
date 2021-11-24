package BaekJoon.Java;
// https://www.acmicpc.net/problem/2839

import java.util.Scanner;

public class baekjoon_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5001];

		for(int i = 0; i < arr.length; i++)
			arr[i] = 9999;
		arr[3] = 1;
		arr[5] = 1;

		for(int i = 6; i < arr.length; i++) {
			if(arr[i-3] != 9999 || arr[i-5] != 9999)
				arr[i] = min(arr[i-3], arr[i-5]) + 1;
		}

		int n = sc.nextInt();

		if(arr[n] == 9999)
			System.out.println("-1");
		else
			System.out.println(arr[n]);

		sc.close();
	}

	public static int min(int x, int y) {
		return (x > y) ? y : x;
	}
}