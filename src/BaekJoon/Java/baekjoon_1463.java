package BaekJoon.Java;
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
			arr[i] = arr[i - 1] + 1;
			
			if ((i % 3) == 0) {
				arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
			}
			
			if ((i % 2) == 0) {
				arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
			}
		}

		System.out.println(arr[x]);
		br.close();
	}
}