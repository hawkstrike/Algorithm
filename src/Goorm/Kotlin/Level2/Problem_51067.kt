package Goorm.Kotlin.Level2

// https://level.goorm.io/exam/51067/%ED%8A%B9%EB%B3%84%ED%95%9C-%EB%AC%B8%EC%9E%90-%EA%B8%B0%ED%98%B8-%EC%BC%80%EC%9D%B4%ED%81%AC-%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0/quiz/1
fun main(args: Array<String>) {
	val n: Int = readLine()!!.trim().toInt()
	val cake: StringBuilder = StringBuilder()
	val candle: StringBuilder = StringBuilder()
	
	candle.append("   ^   ^   ^\n")
	candle.append("   o   o   o\n")
	candle.append("   |   |   |\n")
	cake.append("/-------------\\\n")
	cake.append("|\"* * * * * *\"|\n")
	cake.append("|'* * * * * *'|\n")
	cake.append("|  !@#\$%^&()  |\n")
	cake.append("\\-------------/")
	
	if (n % 2 === 0) {
		print(candle.toString())
		print(cake.toString())
	} else {
		print(candle.toString())
	}
	
	candle.clear()
	cake.clear()
}