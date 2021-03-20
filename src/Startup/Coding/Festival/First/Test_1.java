package Startup.Coding.Festival.First;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_1 {
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int from = Integer.MIN_VALUE;
		int to = Integer.MAX_VALUE;
		int[][] hourArr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			String inputLine = br.readLine().replaceAll("[\\s\\:]", "");
			String[] hourStrArr = inputLine.split("~");
			
			hourArr[i][0] = Integer.parseInt(hourStrArr[0]);
			hourArr[i][1] = Integer.parseInt(hourStrArr[1]);
		}
		
		for (int[] arr : hourArr) {
			if (from > arr[1]) {
			
			}
			
			from = Math.max(from, arr[0]);
			from = Math.min(from, arr[1]);
			
			to = Math.min(to, arr[1]);
			to = Math.max(to, arr[0]);
			
		}
		
		if (from > to) {
			sb.append("-1");
		} else {
			String fromStr = Integer.toString(from);
			String toStr = Integer.toString(to);
			
			sb.append(fromStr.substring(0, 2)).append(":").append(fromStr.substring(2, 4));
			sb.append(" ~ ");
			sb.append(toStr.substring(0, 2)).append(":").append(toStr.substring(2, 4));
		}
		
		System.out.println(sb.toString());
		
		/*StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int from = Integer.MIN_VALUE;
		int to = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			String inputLine = br.readLine().replaceAll("[\\s\\:]", "");
			String[] hourArr = inputLine.split("~");
			
			from = Math.max(from, Integer.parseInt(hourArr[0]));
			to = Math.min(to, Integer.parseInt(hourArr[1]));
			
		}
		
		if (from > to) {
			sb.append("-1");
		} else {
			String fromStr = Integer.toString(from);
			String toStr = Integer.toString(to);
			
			sb.append(fromStr.substring(0, 2)).append(":").append(fromStr.substring(2, 4));
			sb.append(" ~ ");
			sb.append(toStr.substring(0, 2)).append(":").append(toStr.substring(2, 4));
		}
		
		System.out.println(sb.toString());*/
	}
}