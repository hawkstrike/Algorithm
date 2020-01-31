package BaekJoon.java;
// https://www.acmicpc.net/problem/2010

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;

		for(int i = 0; i < n; i++) {
			int tab = Integer.parseInt(br.readLine());
			result += tab;
		}

		System.out.println(result - (n - 1));
		br.close();
	}
}