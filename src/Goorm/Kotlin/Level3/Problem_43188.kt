package Goorm.Kotlin.Level3

import kotlin.math.pow
import kotlin.math.sqrt

// https://level.goorm.io/exam/43188/%EC%9D%B4%EC%B0%A8-%EB%B0%A9%EC%A0%95%EC%8B%9D%EC%9D%98-%ED%95%B4/quiz/1
fun main(args: Array<String>) {
	val coefficientInfoList: List<Int> = readLine()!!.split(" ")
			.map { value -> value.toInt() }
			.toList()
	val a: Int = coefficientInfoList[0]
	val b: Double = coefficientInfoList[1].toDouble()
	val c: Int = coefficientInfoList[2]
	val x1: Double = (-b + sqrt(b.pow(2) - 4 * a * c)) / (2 * a)
	val x2: Double = (-b - sqrt(b.pow(2) - 4 * a * c)) / (2 * a)
	
	if (b.pow(2) - 4 * a * c < 0) {
		println("X")
	} else if (x1 !== x2) {
		println("%.2f".format(x1) + ", %.2f".format(x2))
	} else {
		println("%.2f".format(x1))
	}
}