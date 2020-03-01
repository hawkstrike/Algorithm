package LeetCode.Algorithms.Java;

import java.util.LinkedList;

// https://leetcode.com/problems/maximum-69-number/
public class Maximum_69_Number {
	public static void main(String[] args){
		int num = 669; // 9999; // 9669;
		
		System.out.println(maximum69Number(num));
	}
	
	public static int maximum69Number(int num) {
		int result = num;
		LinkedList<Integer> list = new LinkedList<>();
		
		while (num > 0) {
			int n = num % 10;
			
			list.addFirst(n);
			num /= 10;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 6) {
				list.set(i, 9);
				break;
			}
		}
		
		int compare = 0;
		
		for (int i = 0; i < list.size(); i++) {
			int square = (int) Math.pow(10, list.size() - i - 1);
			
			compare += square * list.get(i);
		}
		
		result = Math.max(result, compare);
		
		return result;
		/*int result = num;
		int[] numArr = Stream.of(Integer.toString(num).split("")).mapToInt(Integer::parseInt).toArray();
		int length = numArr.length;
		
		for (int i = 0; i < length; i++) {
			int changeNumer = (numArr[i] == 6) ? 9 : 6;
			int compareNumber = 0;
			
			for (int j = 0; j < length; j++) {
				int square = length - j - 1;
				compareNumber += (i == j) ? (int) (Math.pow(10, square) * changeNumer) : (int) (Math.pow(10, square) * numArr[j]);
			}
			
			result = Math.max(result, compareNumber);
		}
		
		return result;*/
	}
}