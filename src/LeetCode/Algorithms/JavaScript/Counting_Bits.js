/**
 * https://leetcode.com/problems/counting-bits/
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
	// const arr = new Uint8Array(num + 1);
	const arr = [0];
	
	for (let i = 0; i <= num; i++) {
		arr[i] = arr[i >> 1] + (i & 1);
	}
	
	return [...arr];
};

const num = 5;

console.log(countBits(num));