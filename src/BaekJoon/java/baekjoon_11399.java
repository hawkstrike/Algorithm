package BaekJoon.java;
// https://www.acmicpc.net/problem/11399

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] time = new int[n];
		int sum = 0;
		int[] result = new int[n];

		for(int i = 0; i < n; i++)
			time[i] = Integer.parseInt(token.nextToken());
		Arrays.sort(time);

		for(int i = 0; i < n; i++) {
			sum = time[i] + sum;
			result[i] = sum;
		}

		sum = 0;

		for(int i = 0; i < n; i++)
			sum += result[i];

		System.out.println(sum);
		br.close();
	}
}