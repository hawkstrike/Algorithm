package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/angle-between-hands-of-a-clock/
public class Angle_Between_Hands_of_a_Clock {
	public static void main(String[] args) {
		int hour = 12;
		int minutes = 30;
		
		System.out.println(angleClock(hour, minutes));
	}
	
	public static double angleClock(int hour, int minutes) {
		double hourAngle = (hour * 60 + minutes) * 0.5;
		double minutesAngle = minutes * 6;
		double angle = Math.abs(hourAngle - minutesAngle);
		
		return Math.min(angle, 360 - angle);
	}
}