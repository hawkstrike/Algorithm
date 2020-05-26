/**
 * https://leetcode.com/problems/move-zeroes/
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
	let index = 0;
	
	for (let n of nums) {
		if (n !== 0) {
			nums[index++] = n;
		}
	}
	
	for (let i = index; i < nums.length; i++) {
		nums[i] = 0;
	}
};

let nums = [0, 1, 0, 3, 12];

console.log(moveZeroes(nums));