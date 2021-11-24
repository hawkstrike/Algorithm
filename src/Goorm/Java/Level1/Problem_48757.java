package Goorm.Java.Level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://level.goorm.io/exam/48757/369-%EA%B2%8C%EC%9E%84/quiz/1
public class Problem_48757 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 1; i < n; i++) {
			String str = Integer.toString(i);
			
			if (str.indexOf("3") >= 0 || str.indexOf("6") >= 0 || str.indexOf("9") >= 0) {
				for (char c : str.toCharArray()) {
					if (c == '3' || c == '6' || c == '9') {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
}