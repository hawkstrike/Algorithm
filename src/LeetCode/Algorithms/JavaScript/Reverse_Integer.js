/**
 * https://leetcode.com/problems/reverse-integer/
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
	let number = 0;
	
	while (x !== 0) {
		let rest = x % 10;
		
		x = Math.trunc(x / 10);
		number = number * 10 + rest;
	}
	
	if (-(2 ** 31) >= number || number >= (2 ** 31) - 1) {
		number = 0;
	}
	
	return number;
};

let x = 123;

console.log(reverse(x));