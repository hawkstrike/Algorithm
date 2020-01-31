package BaekJoon.java;
// https://www.acmicpc.net/problem/2822

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_2822 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[8];
		int[] arr2 = new int[8];
		int[] arr3 = new int[5];
		int sum = 0, cnt = 0;

		for(int i = 0; i < 8; i++)
			arr1[i] = arr2[i] = sc.nextInt();

		Arrays.sort(arr1);

		for(int i = 3; i < 8; i++) {
			sum += arr1[i];
			for(int j = 0; j < 8; j++)
				if(arr1[i] == arr2[j])
					arr3[cnt++] = j+1;
		}

		Arrays.sort(arr3);
		System.out.println(sum);

		for(int i = 0; i < 5; i++)
			System.out.print(arr3[i] + " ");

		sc.close();
	}
}