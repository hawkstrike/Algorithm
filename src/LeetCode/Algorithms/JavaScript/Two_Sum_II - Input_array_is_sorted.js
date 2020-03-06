/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
	const obj = {};
	
	for (let i = 0; i < numbers.length; i++) {
		let key = target - numbers[i];
		
		if (obj[key] !== undefined) {
			return [obj[key] + 1, i + 1];
		}
		
		obj[numbers[i]] = i;
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

let numbers = [2, 7, 11, 15];
let target = 9;

console.log(twoSum(numbers, target));