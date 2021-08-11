package Programmers.Practice.Level2;

// 단체사진 찍기
// https://programmers.co.kr/learn/courses/30/lessons/1835
public class Problem_1835 {
	private static int count;
	
	public static void main(String[] args) {
		/*int n = 2;
		String[] data = {"N~F=0", "R~T>2"};*/
		int n = 2;
		String[] data = {"M~C<2", "C~M>1"};
		
		System.out.println(solution(n, data));
	}
	
	public static int solution(int n, String[] data) {
		String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
		boolean[] visited = new boolean[friends.length];
		
		count = 0;
		
		dfs(data, friends, visited, "");
		
		return count;
	}
	
	public static void dfs(String[] data, String[] friends, boolean[] visited, String line) {
		if (line.length() == 7) {
			if (checkLine(data, line)) {
				count++;
			}
			
			return;
		}
		
		for (int i = 0; i < friends.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(data, friends, visited, line + friends[i]);
				visited[i] = false;
			}
		}
	}
	
	public static boolean checkLine(String[] data, String line) {
		for (String s : data) {
			int friend1 = line.indexOf(s.charAt(0));
			int friend2 = line.indexOf(s.charAt(2));
			char oper = s.charAt(3);
			int interval = s.charAt(4) - '0' + 1;
			int gap = Math.abs(friend1 - friend2);
			
			if (oper == '=' && gap != interval) {
				return false;
			} else if (oper == '>' && gap <= interval) {
				return false;
			} else if (oper == '<' && gap >= interval) {
				return false;
			}
		}
		
		return true;
	}
}