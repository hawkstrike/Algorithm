package Goorm.Kotlin.Level2

// https://level.goorm.io/exam/54455/%EC%84%9C%EB%A1%9C-%EB%8B%A4%EB%A5%B8-substring-%EB%A7%8C%EB%93%A4%EA%B8%B0/quiz/1
fun main(args: Array<String>) {
	val inputString: String = readLine()!!
	val hashSet: HashSet<String> = HashSet()
	
	for (i: Int in inputString.indices) {
		hashSet.add(inputString[i].toString())
		
		for (j: Int in (i + 1)..inputString.length) {
			hashSet.add(inputString.substring(i, j))
		}
	}
	
	println(hashSet.size)
}