/**
 * https://leetcode.com/problems/backspace-string-compare/
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
var backspaceCompare = function(S, T) {
	/**
	 * @param {string} str
	 */
	const compareString = (str) => {
		const list = [];
		
		for (s of str.split('')) {
			(s === '#') ? list.pop() : list.push(s);
		}
		
		return list.join('');
	};
	
	return compareString(S) === compareString(T);
};

let S = "ab#c";
let T = "ad#c";

console.log(backspaceCompare(S, T));