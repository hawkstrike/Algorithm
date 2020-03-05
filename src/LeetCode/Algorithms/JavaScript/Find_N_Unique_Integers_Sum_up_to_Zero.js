/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * @param {number} n
 * @return {number[]}
 */
var sumZero = function(n) {
	let result = [];
	
	for (let i = 1; i < n; i += 2) {
		result.push(i, -i);
	}
	
	if (n % 2 == 1) {
		result.push(0);
	}
	
	return result;
};

let n = 5;

console.log(sumZero(n));