package LeetCode.Algorithms;

// https://leetcode.com/problems/defanging-an-ip-address/
public class Defanging_an_IP_Address {
	public static void main(String[] args){
		String address = "255.100.50.0"; // "1.1.1.1";

		System.out.println(defangIPaddr(address));
	}

	public static String defangIPaddr(String address) {
		return address.replace(".", "[.]");
	}
}