/**
 * https://leetcode.com/problems/single-number/
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
	for (let i = 1; i < nums.length; i++) {
		nums[0] = nums[0] ^ nums[i];
	}
	
	return nums[0];
	
	/*let set = new Set();
	
	for (let n of nums) {
		if (set.has(n)) {
			set.delete(n);
		} else {
			set.add(n);
		}
	}
	
	return set.keys().next().value;*/
};

let nums = [2, 2, 1];

console.log(singleNumber(nums));