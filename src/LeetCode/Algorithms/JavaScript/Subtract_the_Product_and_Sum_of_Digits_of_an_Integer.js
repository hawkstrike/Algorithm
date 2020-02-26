/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * @param {number} n
 * @return {number}
 */
var subtractProductAndSum = function(n) {
	let product = 1;
	let sum = 0;
	let rest = 0;
	
	while (n > 0) {
		rest = n % 10;
		n = parseInt(n / 10);
		
		product *= rest;
		sum += rest;
	}
	
	return (product - sum);
};

let n = 4421;

console.log(subtractProductAndSum(n));