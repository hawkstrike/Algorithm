package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class Encode_and_Decode_TinyURL {
	public static class Codec {
		private HashMap<String, String> hashMap = new HashMap<>();
		private String baseUrl = "http://tinyurl.com/";
		
		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			String encodeUrl = baseUrl + longUrl.hashCode();
			
			hashMap.put(encodeUrl, longUrl);
			
			return encodeUrl;
		}
		
		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			return hashMap.get(shortUrl);
		}
	}
	
	public static void main(String[] args) {
		String url = "https://leetcode.com/problems/encode-and-decode-tinyurl/";
		Codec codec = new Codec();
		
		System.out.println(codec.encode(url));
		System.out.println(codec.decode(codec.encode(url)));
	}
}