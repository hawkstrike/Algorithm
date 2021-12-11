package RSQUARE.CodingTest.Challenge1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] nameArr = new String[n][2];
		
		for (int i = 0; i < n; i++) {
			nameArr[i] = br.readLine().split(" ");
		}
		
		for (int i = 0; i < n; i++) {
			String firstName = nameArr[i][0].toLowerCase();
			String lastName = nameArr[i][1].toLowerCase();
			String formattedFirstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);
			String formattedLastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
			
			System.out.println("Case #" + (i + 1));
			System.out.println(formattedFirstName + " " + formattedLastName);
		}
		
		br.close();
	}
}