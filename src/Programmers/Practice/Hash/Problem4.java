package Programmers.Practice.Hash;

import java.util.*;

public class Problem4 {
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] result = solution(genres, plays);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, List<Music>> hashMap = new HashMap<>();
		HashMap<String, Integer> totalPlaysHashMap = new HashMap<>();
		List<Music> totalPlaysList = new ArrayList<>();
		int length = genres.length;
		
		for (int i = 0; i < length; i++) {
			hashMap.putIfAbsent(genres[i], new ArrayList<>());
			hashMap.get(genres[i]).add(new Music(i, plays[i]));
			totalPlaysHashMap.put(genres[i], totalPlaysHashMap.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		for (String key : totalPlaysHashMap.keySet()) {
			totalPlaysList.add(new Music(key, totalPlaysHashMap.get(key)));
		}
		
		Collections.sort(totalPlaysList, ((o1, o2) -> o2.plays - o1.plays));
		
		for (String key : hashMap.keySet()) {
			Collections.sort(hashMap.get(key), ((o1, o2) -> o2.plays - o1.plays));
		}
		
		List<Integer> resultList = new ArrayList<>();
		
		for (Music music : totalPlaysList) {
			List<Music> list = hashMap.get(music.genre);
			
			for (int i = 0; i < 2 && i < list.size(); i++) {
				resultList.add(list.get(i).index);
			}
		}
		
		return resultList.stream().mapToInt(Integer::intValue).toArray();
		//return resultList.stream().mapToInt(i -> i).toArray();
	}
	
	public static class Music {
		String genre;
		int index;
		int plays;
		
		public Music(int index, int plays) {
			this.index = index;
			this.plays = plays;
		}
		
		public Music(String genre, int plays) {
			this.genre = genre;
			this.plays = plays;
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			
			sb.append("{genre : ").append(genre).append(" | ");
			sb.append("index : ").append(index).append(" | ");
			sb.append("plays : ").append(plays).append("}");
			
			return sb.toString();
		}
	}
}