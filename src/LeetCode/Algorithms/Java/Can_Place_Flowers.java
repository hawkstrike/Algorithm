package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/can-place-flowers/
public class Can_Place_Flowers {
	public static void main(String[] args) {
		int[] flowerbed = {1, 0, 0, 0, 1};
		int n = 1;
		
		System.out.println(canPlaceFlowers(flowerbed, n));
	}
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int index = 0;
		int count = 0;
		
		while (index < flowerbed.length) {
			if (flowerbed[index] == 0 && (index == 0 || flowerbed[index - 1] == 0) &&
					(index == flowerbed.length - 1 || flowerbed[index + 1] == 0)) {
				flowerbed[index++] = 1;
				count++;
			}
			
			if (count >= n) {
				return true;
			}
			
			index++;
		}
		
		return false;
	}
}