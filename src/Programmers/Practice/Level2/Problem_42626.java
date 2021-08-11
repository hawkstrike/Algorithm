package Programmers.Practice.Level2;

import java.util.PriorityQueue;

// 더 맴게
// https://programmers.co.kr/learn/courses/30/lessons/42626
public class Problem_42626 {
	
	public static void main(String[] args) {
		//int[] scoville = {1, 2, 3, 9, 10, 12};
		//int[] scoville = {1, 7};
		//int K = 7;
		int[] scoville = {1, 1, 2};
		int K = 3;
		
		System.out.println(solution(scoville, K));
	}
	
	// 6 7 10 13
	// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		int count = 0;
		
		for (int scov : scoville) {
			priorityQueue.offer(scov);
		}
		
		while (!priorityQueue.isEmpty() && priorityQueue.peek() <= K) {
			if (priorityQueue.size() == 1) {
				return -1;
			}
			
			int index = priorityQueue.poll() + (priorityQueue.poll() * 2);
			
			priorityQueue.offer(index);
			count++;
		}
		
		return count;
	}
	/*public static int solution(int[] scoville, int K) {
		List<Integer> list = Arrays.stream(scoville)
				.filter(integer -> integer < K)
				.boxed()
				.collect(Collectors.toList());
		
		return recurrent(list, K, 0);
	}
	
	public static int recurrent(List<Integer> list, int K, int count) {
		if (list.size() == 0) {
			return count;
		} else if (list.size() == 1) {
			return -1;
		}
		
		Collections.sort(list);
		
		int index = (int) (list.get(0) + list.get(1) * 2);
		
		list.remove(0);
		list.remove(0);
		
		if (index < K) {
			list.add(index);
		}
		
		return recurrent(list, K, count + 1);
	}*/
}