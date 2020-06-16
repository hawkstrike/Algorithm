package LeetCode.Algorithms.Java;

import java.util.regex.Pattern;

// https://leetcode.com/problems/validate-ip-address/
public class Validate_IP_Address {
	public static void main(String[] args) {
		String IP = "172.16.254.1";
		
		System.out.println(validIPAddress(IP));
	}
	
	public static String validIPAddress(String IP) {
		String ipv4PatternStr = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
		String ipv6PatternStr = "([0-9a-fA-F]{1,4})";
		Pattern ipv4Pattern = Pattern.compile("^(" + ipv4PatternStr + "\\.){3}" + ipv4PatternStr + "$");
		Pattern ipv6Pattern = Pattern.compile("^(" + ipv6PatternStr + "\\:){7}" + ipv6PatternStr + "$");
		
		return ipv4Pattern.matcher(IP).matches() ? "IPv4" : ipv6Pattern.matcher(IP).matches() ? "IPv6" : "Neither";
	}
}