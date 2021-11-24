package BaekJoon.Java;
// https://www.acmicpc.net/problem/1495

import java.util.Scanner;

public class baekjoon_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] score = new double[n];
		double avg = 0.0;
		double max = 0.0;

		for(int i = 0; i < score.length; i++) {
			score[i] = sc.nextInt();

			if(score[i] > max)
				max = score[i];
		}

		for(int i = 0; i < score.length; i++) {
			score[i] = (double)(score[i] / max) * 100.0;
			avg += score[i];
		}

		avg /= n;

		System.out.printf("%.2f\n", avg);

		sc.close();
	}
}