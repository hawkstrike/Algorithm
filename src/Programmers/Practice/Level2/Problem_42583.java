package Programmers.Practice.Level2;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
// https://programmers.co.kr/learn/courses/30/lessons/42583
public class Problem_42583 {
	
	public static void main(String[] args) {
		/*int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};*/
		/*int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};*/
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> truckQueue = new LinkedList<>();
		Queue<Integer> bridgeStatus = new LinkedList<>();
		
		for (int truckWeight : truck_weights) {
			truckQueue.offer(truckWeight);
		}
		
		for (int i = 0; i < bridge_length; i++) {
			bridgeStatus.offer(0);
		}
		
		int totalWeight = 0;
		int time = 0;
		
		while (!bridgeStatus.isEmpty()) {
			totalWeight -= bridgeStatus.poll();
			
			if (truckQueue.isEmpty()) {
				return time + bridge_length;
			}
			
			if ((totalWeight + truckQueue.peek()) <= weight) {
				int truckWeight = truckQueue.poll();
				
				bridgeStatus.offer(truckWeight);
				totalWeight += truckWeight;
			} else {
				bridgeStatus.offer(0);
			}
			
			time++;
		}
		
		return time;
	}
}