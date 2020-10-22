
/**
 * https://leetcode.com/problems/contiguous-array/solution/
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
	const hashMap = new Map();
	let maxlen = 0;
	let count = 0;
	
	hashMap.set(0, -1);
	
	for (let i = 0; i < nums.length; i++) {
		count = count + (nums[i] === 1 ? 1 : -1);
		
		if (hashMap.has(count)) {
			maxlen = Math.max(maxlen, i - hashMap.get(count));
		} else {
			hashMap.set(count, i);
		}
	}
	
	return maxlen;
};

// const nums = [0, 1];
const nums = [0, 0, 1];

console.log(findMaxLength(nums));