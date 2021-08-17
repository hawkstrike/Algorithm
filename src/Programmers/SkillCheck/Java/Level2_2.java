package Programmers.SkillCheck.Java;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Level2_2 {
	
	public static void main(String[] args) {
		String m = "ABCDEFG";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		System.out.println(solution(m, musicinfos));
	}
	
	public static String solution(String m, String[] musicinfos) {
		String[][] musicSheetInfoArr = {{"C#", "c"}, {"D#", "d"}, {"F#", "f"}, {"G#", "g"}, {"A#", "a"}};
		String musicName = "None";
		int max = Integer.MIN_VALUE;
		
		for (String[] musicSheetInfo : musicSheetInfoArr) {
			m = m.replace(musicSheetInfo[0], musicSheetInfo[1]);
		}
		
		for (String musicInfo : musicinfos) {
			String[] musicInfoArr = musicInfo.split(",");
			LocalTime startTime = LocalTime.parse(musicInfoArr[0], DateTimeFormatter.ofPattern("HH:mm"));
			LocalTime endTime = LocalTime.parse(musicInfoArr[1], DateTimeFormatter.ofPattern("HH:mm"));
			int time = (endTime.getHour() - startTime.getHour()) * 60 + (endTime.getMinute() - startTime.getMinute());
			String musicSheet = musicInfoArr[3];
			StringBuffer fullMusicSheet = new StringBuffer();
			
			for (String[] musicSheetInfo : musicSheetInfoArr) {
				musicSheet = musicSheet.replace(musicSheetInfo[0], musicSheetInfo[1]);
			}
			
			if (time > musicSheet.length()) {
				for (int i = 0; i < time / musicSheet.length(); i++) {
					fullMusicSheet.append(musicSheet);
				}
				
				fullMusicSheet.append(musicSheet.substring(0, time % musicSheet.length()));
			} else {
				fullMusicSheet.append(musicSheet.substring(0, time));
			}
			
			if (fullMusicSheet.toString().contains(m) && time > max) {
				max = time;
				musicName = musicInfoArr[2];
			}
		}
		
		return musicName;
	}
	
	public static class Music {
		int time;
		String musicName;
		String musicSheet;
		
		public Music(int time, String musicName, String musicSheet) {
			this.time = time;
			this.musicName = musicName;
			this.musicSheet = musicSheet;
		}
	}
}