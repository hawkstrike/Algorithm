package BaekJoon.Java;
// https://www.acmicpc.net/problem/4095

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_4095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		while(true) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

			if(n == 0 && m == 0)
				break;

			int width = 0;
			int[][] field = new int[n+1][m+1];

			for(int i = 1; i <= n; i++) {
				s = br.readLine().split(" ");

				for(int j = 1; j <= m; j++)
					field[i][j] = Integer.parseInt(s[j-1]);
			}

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++)
					if(field[i][j] != 0) {
						field[i][j] = Math.min(field[i-1][j-1], Math.min(field[i-1][j], field[i][j-1])) + 1;
						if(width < field[i][j])
							width = field[i][j];
					}
			}

			sb.append(width + "\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}