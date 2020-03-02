/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
	let result = 0;
	
	for (let n of nums) {
		if (String(n).length % 2 === 0) {
			result++;
		}
	}
	
	return result;
};

let nums = [12, 345, 2, 6, 7896];

console.log(findNumbers(nums));