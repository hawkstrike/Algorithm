package Programmers.Practice.Level1;

import java.util.Arrays;
import java.util.HashSet;

// 체육복
// https://programmers.co.kr/learn/courses/30/lessons/42862
public class Problem_42862 {
	
	public static void main(String[] args) {
		/*int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};*/
		/*int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {3};*/
		/*int n = 3;
		int[] lost = {3};
		int[] reserve = {1};*/
		/*int n = 10;
		int[] lost = {5, 4, 3, 2, 1};
		int[] reserve = {3, 1, 2, 5, 4};*/
		/*int n = 5;
		int[] lost = {2, 3, 4};
		int[] reserve = {1, 2, 3};*/
		/*int n = 7;
		int[] lost = {1, 2, 3, 4, 5, 6, 7};
		int[] reserve = {1, 2, 3};*/
		int n = 4;
		int[] lost = {3, 1, 2};
		int[] reserve = {2, 4, 3};
		
		System.out.println(solution(n, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		HashSet<Integer> lostHashSet = new HashSet<>();
		HashSet<Integer> reserveHashSet = new HashSet<>();
		
		Arrays.sort(lost);
		
		for (int student : lost) {
			lostHashSet.add(student);
		}
		
		for (int student : reserve) {
			if (!lostHashSet.contains(student)) {
				reserveHashSet.add(student);
			} else {
				lostHashSet.remove(student);
			}
		}
		
		for (int student : lost) {
			if (reserveHashSet.contains(student - 1)) {
				reserveHashSet.remove(student - 1);
				lostHashSet.remove(student);
			} else if (reserveHashSet.contains(student + 1)) {
				reserveHashSet.remove(student + 1);
				lostHashSet.remove(student);
			}
		}
		
		return (n - lostHashSet.size());
	}
}