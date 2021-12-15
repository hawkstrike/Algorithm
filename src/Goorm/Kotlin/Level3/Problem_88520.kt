package Goorm.Kotlin.Level3

fun main(args: Array<String>) {
	val T: Int = readLine()!!.toInt()
	
	for (test_case: Int in 0 until T) {
		val areaInfoList: List<Int> = readLine()!!.split(" ")
				.map { value -> value.toInt() }
				.toList()
		val N: Int = areaInfoList[0]
		val K: Int = areaInfoList[1]
		val range: Int = N - K
		val field: Array<IntArray> = Array(N) {IntArray(N)}
		
		for (index: Int in 0 until N) {
			field[index] = readLine()!!.split(" ")
					.map { value -> value.toInt() }
					.toIntArray()
		}
		
		var min: Int = Int.MAX_VALUE
		
		for (i: Int in 0..range) {
			for (j: Int in 0..range) {
				var count: Int = 0
				
				for (x: Int in 0 until K) {
					for (y: Int in 0 until K) {
						if (field[i + x][j + y] == 1) {
							count++
						}
					}
				}
				
				min = min.coerceAtMost(count)
			}
		}
		
		print(min)
	}
}