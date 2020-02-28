/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings
 * @param {string} s
 * @return {number}
 */
var balancedStringSplit = function(s) {
	let result = 0;
	let balance = 0;
	
	for (const c of s) {
		balance += (c === 'R') ? 1 : -1;
		result += (balance === 0) ? 1 : 0;
	}
	
	return result;
};

let s = 'RLRRLLRLRL';

console.log(balancedStringSplit(s));