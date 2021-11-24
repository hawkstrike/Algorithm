package BaekJoon.Java;
// https://www.acmicpc.net/problem/1110

import java.util.Scanner;

public class baekjoon_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int front = 0;
		int rear = 0;
		int count = 0;
		int answer = n;

		while(true) {
			front = n / 10;
			rear = n % 10;
			n = (rear * 10) + (front + rear) % 10;
			count++;

			if(answer == n)
				break;
		}

		System.out.println(count);
		sc.close();
	}
}