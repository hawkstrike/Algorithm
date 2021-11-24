package BaekJoon.Java;
// https://www.acmicpc.net/problem/5585

import java.util.Scanner;

public class baekjoon_5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int balance = 0;
		int count = 0;

		money = 1000 - money;

		while(money > 0) {
			if(money >= 500) {
				balance = money / 500;
				money %= 500;
				count += balance;
			} else if(money >= 100 && money < 500) {
				balance = money / 100;
				money %= 100;
				count += balance;
			} else if(money >= 50 && money < 100) {
				balance = money / 50;
				money %= 50;
				count += balance;
			} else if(money >= 10 && money < 50) {
				balance = money / 10;
				money %= 10;
				count += balance;
			} else if(money >= 5 && money < 10) {
				balance = money / 5;
				money %= 5;
				count += balance;
			} else if(money >= 1 && money < 5) {
				money--;
				count++;
			}
		} // end of while

		System.out.println(count);
		sc.close();
	}
}