package Goorm.Kotlin.Level3

import java.util.*

// https://level.goorm.io/exam/43250/%EB%B0%B0%EC%97%B4-%ED%95%A9%EC%B9%98%EA%B8%B0/quiz/1
fun main(args: Array<String>) {
	val sizeInfoList: List<Int> = readLine()!!.split(" ")
			.map { size -> size.toInt() }
			.toList()
	val a: List<Int> = readLine()!!.split(" ")
			.map { value -> value.toInt() }
			.toList()
	val b: List<Int> = readLine()!!.split(" ")
			.map { value -> value.toInt() }
			.toList()
//	val c: List<Int> = a + b
	val c: List<Int> = a.plus(b)
	
	Collections.sort(c)
	
	for (value: Int in c) {
		print("$value ")
	}
	println()
}