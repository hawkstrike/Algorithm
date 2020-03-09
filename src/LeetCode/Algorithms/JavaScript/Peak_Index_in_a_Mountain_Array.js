/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * @param {number[]} A
 * @return {number}
 */
var peakIndexInMountainArray = function(A) {
	let max = A[0];
	let index = 0;
	
	for (let i = 1; i < A.length; i++) {
		if (A[i] > max) {
			max = A[i];
			index = i;
		}
	}
	
	return index;
};

let A = [0, 2, 1, 0]; // [0, 1, 0];

console.log(peakIndexInMountainArray(A));