package BaekJoon.Java;
// https://www.acmicpc.net/problem/1987

import java.util.Scanner;

public class baekjoon_1987 {
	static int R, C, max = 0;
	static char[][] arr;
	static boolean[] v = new boolean[26];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		sc.nextLine();

		for(int i = 0; i < R; i++)
			arr[i] = sc.nextLine().toCharArray();

		v[arr[0][0]-65] = true;
		dfs(0, 0, 1);
		System.out.println(max);
		sc.close();
	}

	public static void dfs(int x, int y, int cnt) {
		if(cnt > max)
			max = cnt;

		for(int i = 0; i < 4; i++) {
			int currX = x + dx[i];
			int currY = y + dy[i];

			if(currX >= 0 && currY >= 0 && currX < R && currY < C) {
				int here = arr[currX][currY] - 65;

				if(!v[here]) {
					v[here] = true;
					dfs(currX, currY, cnt+1);
					v[here] = false;
				}
			}
		}
	}
}