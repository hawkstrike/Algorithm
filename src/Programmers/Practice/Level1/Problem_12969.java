package Programmers.Practice.Level1;

import java.util.Scanner;

// 직사각형 별찍기
// https://programmers.co.kr/learn/courses/30/lessons/12969
public class Problem_12969 {
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				sb.append("*");
				//System.out.print("*");
			}
			sb.append("\n");
			//System.out.println();
		}
		
		System.out.println(sb.toString());
	}
}