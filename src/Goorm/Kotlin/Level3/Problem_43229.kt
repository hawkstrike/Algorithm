package Goorm.Kotlin.Level3

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

// https://level.goorm.io/exam/43229/%EB%B9%A8%EB%9E%98/quiz/1
fun main(args: Array<String>) {
	val firstLine: List<String> = readLine()!!.split(" ")
	val N: Int = firstLine[0].toInt()
	val M: Int = firstLine[1].toInt()
	
	val colorList: List<String> = readLine()!!.split(" ")
	val hashMap: HashMap<String, ArrayList<Int>> = HashMap()
	var time: Int = 0
	
	// hashMap 초기화
	for (i: Int in 0 until N) {
		hashMap[colorList[i]] = ArrayList()
	}
	
	// input data 셋팅
	for (i: Int in 0 until M) {
		val washInfoList: List<String> = readLine()!!.split(" ")
		
		hashMap[washInfoList[1]]!!.add(washInfoList[0].toInt())
	}
	
	// 내림차순 정렬
	for (i: Int in 0 until N) {
		Collections.sort(hashMap[colorList[i]], Collections.reverseOrder())
	}
	
	for (i: Int in 0 until N) {
		val list: ArrayList<Int> = hashMap[colorList[i]]!!
		val size: Int = list.size
		
		if (size > 0) {
			var index: Int = 0
			
			while (index < size) {
				time += list[index]
				
				if (index + 1 < size) {
					index++
				}
				
				index++
			}
		}
	}
	
	println(time)
}
