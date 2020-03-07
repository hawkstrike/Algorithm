/**
 * https://leetcode.com/problems/find-peak-element/
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
	for (let i = 0; i < nums.length - 1; i++) {
		if (nums[i + 1] < nums[i]) {
			return i;
		}
	}
	
	return nums.length - 1;
};

let nums = [1, 2]; // [1, 2, 3, 1];

console.log(findPeakElement(nums));