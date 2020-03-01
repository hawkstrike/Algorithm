/**
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * @param {number[]} nums
 * @return {number[]}
 */
var smallerNumbersThanCurrent = function(nums) {
	const sorted = Array.from(nums).sort((n1, n2) => n2 - n1);
	const map = new Map(sorted.map((num, index) => [num, nums.length - index - 1]));
	
	return nums.map(num => map.get(num));
};

let nums = [8, 1, 2, 2, 3];

console.log(smallerNumbersThanCurrent(nums));