package Startup.Coding.Festival.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < T; i++) {
			String[] inputArr = br.readLine().split(" ");
			long n = Long.parseLong(inputArr[0]); // 시즌 한정 음료 쿠폰
			long m = Long.parseLong(inputArr[1]); // 일반 음료 쿠폰
			long k1 = n / 5;
			long k2 = (n + m) / 12;
			long k = (k1 < k2) ? k1 : k2;
			
			while ((n + m) < 12 * k) {
				if (k == 0) {
					break;
				}
				
				k--;
			}
			
			sb.append(k).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}