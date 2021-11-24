package BaekJoon.Java;
// https://www.acmicpc.net/problem/5054

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_5054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;

		for(int i = 0; i < T; i++) {
			int n = sc.nextInt(); // 상점 수
			int[] shop = new int[n];

			for(int j = 0; j < shop.length; j++) { // 상점 거리 입력
				shop[j] = sc.nextInt();
			}

			int car = shop[0];
			Arrays.sort(shop); // 정렬

			for(int j = 0; j < shop.length; j++) {
				result = 0;

				if(car == shop[j]) {
					for(int k = j; k > 0; k--)
						result += (shop[k] - shop[k-1]);

					for(int k = j; k < shop.length-1; k++)
						result += (shop[k+1] - shop[k]);

					result *= 2;

					System.out.println(result);
				}
			}
		}

		sc.close();
	}
}