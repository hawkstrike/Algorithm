package BaekJoon.Java;
// https://www.acmicpc.net/problem/11723

import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_11723 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = Integer.parseInt(sc.nextLine());
		int s = 0;
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < m; i++) {
			String str = sc.nextLine();

			if(!str.equals("all") && !str.equals("empty")) {
				StringTokenizer st = new StringTokenizer(str);
				String c = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if(c.equals("add"))
					s |= (1 << n);
				else if(c.equals("remove")) {
					if((s & (1 << n)) != 0)
						s = s & ~(1 << n);
				} else if(c.equals("check"))
					sb.append(((s & (1 << n)) > 0) ? "1\n" : "0\n");
				else if(c.equals("toggle"))
					s = ((s & (1 << n)) > 0) ? s & ~(1 << n) : s | (1 << n);
			} else if(str.equals("all")) {
				s = 0;
				for(int j = 1; j <= 20; j++)
					s |= (1 << j);
			}
			else if(str.equals("empty"))
				s = 0;
		}

		System.out.println(sb.toString());
		sc.close();
	}
}