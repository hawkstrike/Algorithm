package Goorm.Kotlin.Level1

// https://level.goorm.io/exam/43111/%ED%99%80%EC%A7%9D-%ED%8C%90%EB%B3%84/quiz/1
fun main(args: Array<String>) {
	val input = Integer.parseInt(readLine())
	val result = if(input % 2 == 1) "odd" else "even"
	/*var result: String = "even"
	
	if((input % 2 == 1)) {
		result = "odd"
	}*/
	
	println(result)
}