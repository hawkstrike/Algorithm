package BaekJoon.Java;
// https://www.acmicpc.net/problem/4344

import java.util.Scanner;

public class baekjoon_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			double count = sc.nextDouble();
			double[] score = new double[(int)count];
			double sum = 0.0;
			double avg = 0.0;
			double check = 0.0;

			for(int j = 0; j < score.length; j++) {
				score[j] = sc.nextDouble();
				sum += score[j];
			}

			avg = sum / count;

			for(int j = 0; j < score.length; j++)
				if(score[j] >  avg)
					check++;

			check = (check / count) * 100.0;
			System.out.printf("%.3f%%\n", check);
		}

		sc.close();
	}
}