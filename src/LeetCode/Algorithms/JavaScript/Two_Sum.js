/**
 * https://leetcode.com/problems/two-sum/
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
	const obj = {};
	
	for (let i = 0; i < nums.length; i++) {
		let key = target - nums[i];
		
		if (obj[key] !== undefined) {
			return [obj[key], i];
		}
		
		obj[nums[i]] = i;
	}
	
	/*const obj = new Map();
	
	for (let i = 0; i < nums.length; i++) {
		let key = target - nums[i];
		
		if (obj.has(key)) {
			return [obj.get(key), i];
		}
		
		obj.set(nums[i], i);
	}*/
};

let nums = [2, 7, 11, 15];
let target = 9;

console.log(twoSum(nums, target));