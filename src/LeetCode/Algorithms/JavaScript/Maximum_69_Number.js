/**
 * https://leetcode.com/problems/maximum-69-number/
 * @param {number} num
 * @return {number}
 */
var maximum69Number  = function(num) {
	/*let numStr = num.toString();
	let index = numStr.indexOf('6');
	
	if (index !== -1) {
		numStr = numStr.substring(0, index) + '9' + numStr.substring(index + 1, numStr.length);
	}
	
	return Math.max(num, parseInt(numStr));*/
	
	return Number(num.toString().replace('6', '9'));
};

let num = 669; // 9669;

console.log(maximum69Number(num));