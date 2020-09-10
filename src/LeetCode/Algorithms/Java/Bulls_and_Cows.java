package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/bulls-and-cows/
public class Bulls_and_Cows {
	public static void main(String[] args) {
		/*String secret = "1807";
		String guess = "7810";*/
		String secret = "1123";
		String guess = "0111";
		
		System.out.println(getHint(secret, guess));
	}
	
	public static String getHint(String secret, String guess) {
		int[] arr = new int[10];
		int bulls = 0;
		int cows = 0;
		
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				if (++arr[secret.charAt(i) - '0'] <= 0) {
					cows++;
				}
				
				if (--arr[guess.charAt(i) - '0'] >= 0) {
					cows++;
				}
			}
		}
		
		return bulls + "A" + cows + "B";
	}
}