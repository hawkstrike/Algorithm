package Goorm.Kotlin.Level2

// https://level.goorm.io/exam/48671/%ED%86%B5%EC%8B%A0%EB%B9%84-%EA%B3%84%EC%82%B0%ED%95%98%EA%B8%B0/quiz/1
fun main(args: Array<String>) {
	/*val infoMap: HashMap<Int, Int> = hashMapOf(Pair(29900, 300), Pair(34900, 1000), Pair(39900, 2000)
			, Pair(49900, 6000), Pair(59900, 11000), Pair(69900, -1))*/
	val feeInfoList: List<Pair<Int, Int>> = listOf(Pair(29900, 300), Pair(34900, 1000), Pair(39900, 2000)
			, Pair(49900, 6000), Pair(59900, 11000), Pair(69900, -1))
	val infoList: List<Int> = readLine()!!.split(" ")
			.map { info: String -> info.toInt() }
			.toList()
	val currFee: Int = infoList[0] // 현재 요금제
	val currData: Int = infoList[1] // 데이터 사용량
	var currDataFee: Int = 0
	var recommend: Pair<Int, Int> = Pair(currFee, 200000)
	var charge: Int = 0
	var temp: Int = 0
	
	for (fee: Pair<Int, Int> in feeInfoList) {
		if (fee.first === 69900) {
			temp = 0
		} else {
			temp = if (currData > fee.second) currData - fee.second else 0
			
			if (temp * 20 > 25000 && temp < 5000) {
				temp = 25000
			} else if (temp * 20 > 180000) {
				temp = 180000
			} else {
				temp *= 20
			}
		}
		
		if (fee.first === currFee) {
			currDataFee = fee.first + temp
			continue
		}
		
		charge = fee.first + temp
		
		if (charge < recommend.second) {
			recommend = Pair(fee.first, charge)
		}
	}
	
	println("${recommend.first} $currDataFee ${recommend.second}")
	
	
	/*var currDataFee: Int = currFee // 현재 요금제로 내야할 요금
	var recommendFee: Pair<Int, Int> = Pair(currFee, currData)
	var gap: Int = Int.MAX_VALUE
	
	for (fee: Pair<Int, Int> in feeInfoList) {
		if (currFee === fee.first && currFee !== feeInfoList[5].first) {
			val exceedFee: Int = calculateDataFee(currData, fee.second)
			
			if (exceedFee !== 0 && exceedFee + currDataFee > 180000) {
				currDataFee = 180000
			} else {
				currDataFee += exceedFee
			}
		}
		
		if (currData <= fee.second && fee.first !== feeInfoList[5].first) {
			val temp: Int = fee.second - currData
			
			if (temp >= 0 && temp < gap) {
				gap = temp;
				recommendFee = Pair(fee.first, fee.second)
			}
		} else if (currData > feeInfoList[4].second) {
			recommendFee = Pair(feeInfoList[5].first, feeInfoList[5].second)
		}
	}
	
	val recommendExceedFee: Int = calculateDataFee(currData, recommendFee.second)
	
	if (recommendExceedFee !== 0 && recommendFee.first !== feeInfoList[5].first) {
		recommendFee = Pair(recommendFee.first, recommendExceedFee)
	}
	
	println("${recommendFee.first} $currDataFee ${recommendFee.first}")*/
}

/*
fun calculateDataFee(currData: Int, feeData: Int): Int {
	val exceedData: Int = currData - feeData
	var exceedFee: Int = 0
	
	if (exceedData >= 1) {
		if (exceedData < 5000) {
			exceedFee = 25000
		} else {
			exceedFee = exceedData * 20
		}
	}
	
	return exceedFee
}*/
