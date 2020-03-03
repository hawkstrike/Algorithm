/**
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 * @param {number[]} nums
 * @return {number[]}
 */
var decompressRLElist = function(nums) {
	const result = [];
	
	for (let i = 0; i < nums.length; i += 2) {
		const arr = new Array(nums[i]).fill(nums[i + 1]);
		
		result.push(...arr);
	}
	
	return result;
};

let nums = [1, 2, 3, 4];

console.log(decompressRLElist(nums));