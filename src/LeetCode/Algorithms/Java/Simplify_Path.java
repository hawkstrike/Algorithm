package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/simplify-path/
public class Simplify_Path {
	public static void main(String[] args) {
		//String path = "/home";
		//String path = "/../";
		//String path = "/home//foo/";
		String path = "/a/./b/../../c/";
		
		System.out.println(simplifyPath(path));
	}
	
	public static String simplifyPath(String path) {
		String[] pathArr = path.split("/");
		Deque<String> deque = new ArrayDeque<>();
		
		for (String p : pathArr) {
			if ("".equals(p) || ".".equals(p)) {
				continue;
			}
			
			if ("..".equals(p)) {
				deque.pollLast();
			} else {
				deque.addLast(p);
			}
		}
		
		return "/" + String.join("/", deque);
	}
}