package RSQUARE.CodingTest.Challenge1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] coreArr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(n -> Integer.parseInt(n))
				.sorted()
				.toArray();
		int time = coreArr[0];
		int max = coreArr[coreArr.length - 1];
		
		for (int i = 1; i < coreArr.length - 1; i++) {
			if (time <= coreArr[i]) {
				time += coreArr[i];
				break;
			}
		}
		
		System.out.println((max > time) ? max : time);
		
		br.close();
	}
}