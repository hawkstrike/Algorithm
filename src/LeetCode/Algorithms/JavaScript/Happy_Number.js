/**
 * https://leetcode.com/problems/happy-number/
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
	/**
	 * @param {Number} n
	 */
	const computeNumber = (n) => {
		let number = 0;
		
		while (n > 0) {
			number += Math.pow(Math.trunc(n % 10), 2);
			n = Math.trunc(n / 10);
		}
		
		return number;
	};
	
	let hashSet = new Set();
	
	hashSet.add(n);
	
	while (n > 1) {
		n = computeNumber(n);
		
		if (hashSet.has(n)) {
			return false;
		} else {
			hashSet.add(n);
		}
	}
	
	return true;
};

let n = 19;

console.log(isHappy(n));