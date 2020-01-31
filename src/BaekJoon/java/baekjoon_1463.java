package BaekJoon.java;
// https://www.acmicpc.net/problem/1463

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int[] arr = new int[x + 1];

		for(int i = 2; i < arr.length; i++) {
			if((i % 3) == 0)
				arr[i] = min(arr[i/3], arr[i-1]) + 1;
			else if((i % 2) == 0)
				arr[i] = min(arr[i/2], arr[i-1]) + 1;
			else
				arr[i] = arr[i-1] + 1;
		}

		System.out.println(arr[x]);
		br.close();
	}

	public static int min(int i, int j) {
		return (i > j) ? j : i;
	}
}