package BaekJoon.java;
// https://www.acmicpc.net/problem/3040

import java.util.Scanner;

public class baekjoon_3040 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[9];
		int result = 0;
		int a = 0, b = 0;

		for(int i = 0; i < n.length; i++) { // 입력 받아오기
			n[i] = sc.nextInt();
			result += n[i];
		}

		int temp = result - 100;

		for(int i = 0; i < n.length; i++) {
			for(int j = i; j < n.length; j++) {
				if(temp == (n[i] + n[j])) {
					a = i;
					b = j;
					break;
				}
			}

			if(a > 0 && b > 0)
				break;
		}

		for(int i = 0; i < n.length; i++) {
			if(a != i && b != i)
				System.out.println(n[i]);
		}

		sc.close();
	}
}