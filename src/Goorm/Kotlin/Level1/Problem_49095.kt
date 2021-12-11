package Goorm.Kotlin.Level1

// https://level.goorm.io/exam/49095/%EA%B3%A0%EC%9E%A5%EB%82%9C-%EC%BB%B4%ED%93%A8%ED%84%B0/quiz/1
fun main(args: Array<String>) {
	val infoList: List<Int> = readLine()!!.split(" ")
			.map { value -> value.toInt() }
			.toList()
	val n: Int = infoList[0] // 입력한 글자 수
	val c: Int = infoList[1] // 코드가 지워지지 않고 유지되는 시간
	val codeList: List<Int> = readLine()!!.split(" ")
			.map { value -> value.toInt() }
			.toList()
	var count: Int = 1
	
	for (i in 1 until n) {
		count++
		
		if (codeList[i] - codeList[i - 1] > c) {
			count = 1
		}
	}
	
	println(count)
}