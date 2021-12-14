package Goorm.Kotlin.Level3

import java.util.*
import kotlin.system.exitProcess

// https://level.goorm.io/exam/43218/%EC%8A%A4%ED%83%9D-stack/quiz/1
fun main(args: Array<String>) {
	val stack: LinkedList<Int> = LinkedList()
	val n: Int = readLine()!!.toInt()
	var index: Int = 0
	
	while (index < n) {
		val command: Int = readLine()!!.toInt()
		
		if (command === 0) { // push
			val value: Int = readLine()!!.toInt()
			
			if (stack.size >= 10) {
				println("overflow")
			} else {
				stack.offer(value)
			}
		} else if (command === 1) { // pop
//			val pollValue: String = (stack.pollLast() ?: "underflow") as String
			val value: Int? = stack.pollLast()
			
			if (value === null) {
				println("underflow")
			}
		} else {
			break
		}
		
		index++
	}
	
	for (value: Int in stack) {
		print("$value ")
	}
}