package BaekJoon.Java;
// https://www.acmicpc.net/problem/14499

import java.util.Scanner;

public class baekjoon_14499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 세로 크기
		int m = sc.nextInt(); // 가로 크기
		int x = sc.nextInt() + 1; // x 좌표
		int y = sc.nextInt() + 1; // y 좌표
		int k = sc.nextInt(); // 명령의 개수
		int[][] field = new int[n+2][m+2];
		int[] dice = new int[6];
		int[] temp = new int[6];

		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++)
				field[i][j] = 10;
		}

		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++)
				field[i][j] = sc.nextInt();

		for(int i = 0; i < k; i++) {
			int direction = sc.nextInt();
			copy(dice, temp);

			if(direction == 3 && field[x-1][y] != 10) { // move north
				x--;
				change(dice, temp, direction);
				copy(dice, field, x, y);
				System.out.println(dice[0]);
			} else if(direction == 4 && field[x+1][y] != 10) { // move south
				x++;
				change(dice, temp, direction);
				copy(dice, field, x, y);
				System.out.println(dice[0]);
			} else if(direction == 1 && field[x][y+1] != 10) { // move east
				y++;
				change(dice, temp, direction);
				copy(dice, field, x, y);
				System.out.println(dice[0]);
			} else if(direction == 2 && field[x][y-1] != 10) { // move west
				y--;
				change(dice, temp, direction);
				copy(dice, field, x, y);
				System.out.println(dice[0]);
			}
		} // end of for

		sc.close();
	}

	public static void copy(int[] dice, int[] temp) {
		for(int i = 0; i < dice.length; i++)
			temp[i] = dice[i];
	}

	public static void copy(int[] dice, int[][] field, int x, int y) {
		if(field[x][y] != 0) {
			dice[4] = field[x][y];
			field[x][y] = 0;
		} else
			field[x][y] = dice[4];
	}

	public static void change(int[] dice, int[] temp, int direction) {
		if(direction == 3) {
			dice[0] = temp[2];
			dice[1] = temp[1];
			dice[2] = temp[4];
			dice[3] = temp[3];
			dice[4] = temp[5];
			dice[5] = temp[0];
		} else if(direction == 4) {
			dice[0] = temp[5];
			dice[1] = temp[1];
			dice[2] = temp[0];
			dice[3] = temp[3];
			dice[4] = temp[2];
			dice[5] = temp[4];
		} else if(direction == 1) {
			dice[0] = temp[1];
			dice[1] = temp[4];
			dice[2] = temp[2];
			dice[3] = temp[0];
			dice[4] = temp[3];
			dice[5] = temp[5];
		} else if(direction == 2) {
			dice[0] = temp[3];
			dice[1] = temp[0];
			dice[2] = temp[2];
			dice[3] = temp[4];
			dice[4] = temp[1];
			dice[5] = temp[5];
		}
	}
}