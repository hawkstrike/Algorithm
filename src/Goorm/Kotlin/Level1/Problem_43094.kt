package Goorm.Kotlin.Level1

import kotlin.math.roundToInt

// https://level.goorm.io/exam/43094/%EC%8B%9C%ED%97%98%EC%84%B1%EC%A0%81-%ED%8F%89%EA%B7%A0%EA%B3%BC-%EB%93%B1%EA%B8%89-%EA%B5%AC%ED%95%98%EA%B8%B0/quiz/1
fun main(args: Array<String>) {
	/*val scoreArr: IntArray = Arrays.stream(readLine()!!.split(" ").toTypedArray())
			.mapToInt{n: String -> n.toInt()}
			.toArray()*/
	val scoreList: List<Int> = readLine()!!.split(" ")
			.map { score -> score.toInt() }
			.toList()
//	val score: Double = round(scoreList.average() * 100) / 100
//	val score: Double = (scoreList.average() * 100).roundToInt() / 100.0
	val score: Double = scoreList.average()
	var grade: Char = ' '
	
	if (score >= 90) {
		grade = 'A'
	} else if (score < 90 && score >= 80) {
		grade = 'B'
	} else if (score < 80 && score >= 70) {
		grade = 'C'
	} else if (score < 70 && score >= 60) {
		grade = 'D'
	} else {
		grade = 'F'
	}
	
	println("%.2f".format(score) + " $grade")
}