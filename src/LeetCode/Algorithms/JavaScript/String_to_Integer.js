/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
	let regex = '^\\s*([+-]?[0-9]+)';
	const minInteger = Math.pow(-2, 31);
	const maxInteger = Math.pow(2, 31) - 1;
	const match = str.match(regex);
	
	if (match) {
		let integer = Number(match[1]);
		
		if (integer > maxInteger) {
			return maxInteger;
		} else if (integer < minInteger) {
			return minInteger;
		}
		
		return integer;
	} else {
		return 0;
	}
};

let str = '    -42';

console.log(myAtoi(str));