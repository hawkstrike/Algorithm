/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * @param {number} num
 * @return {number}
 */
var numberOfSteps  = function(num) {
	if (num === 0) {
		return 0;
	}
	
	return 1 + ((num % 2 === 0) ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
	/*let result = 0;
	
	while (num > 0) {
		num = (num % 2 === 0) ? num / 2 : num - 1;
		result++;
	}
	
	return result;*/
};

let num = 100;

console.log(numberOfSteps(num));